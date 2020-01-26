import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class EBookReader {
    private final String eBookPath;
    private ZipFile zFile;
    private final Document content;
    private final String contentPath;
    private EBook eBook;
    
    public EBookReader(String eBookPath) throws IOException, ParserConfigurationException, TransformerException, SAXException{
        this.eBookPath = eBookPath;
        zFile = new ZipFile(eBookPath);
        DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        ZipEntry ze = getZipEntry("content.opf");
        contentPath = ze.toString();
        try (InputStream is = zFile.getInputStream(getZipEntry("content.opf"))) {
            content = dBuilder.parse(is);
        }
    }
    public EBook readEBook(){
        eBook = new EBook(eBookPath);
        eBook.setMetadata(readMetadata());
        eBook.setSpineMap(readSpineMap());
        eBook.setGuideMap(readGuideMap());
        return eBook;
    }
    public Metadata readMetadata() {
        Node metadataNode = findNode(content, "metadata", true);
        Metadata metadata = new Metadata();
        for(int i=0;i<findNodeList(metadataNode, "dc:creator").size();i++){
            metadata.addCreator((findNodeList(metadataNode, "dc:creator")).get(i).getTextContent());
        }
        metadata.setTitle((findNode(metadataNode, "dc:title", true)).getTextContent());
        for(int i=0;i<findNodeList(metadataNode, "dc:publisher").size();i++){
            metadata.addPublisher((findNodeList(metadataNode, "dc:publisher")).get(i).getTextContent());
        }
        metadata.setDate((findNode(content, "dc:date", true)).getTextContent());
        for(int i=0;i<findNodeList(metadataNode, "dc:subject").size();i++){
            metadata.addSubject((findNodeList(metadataNode, "dc:subject")).get(i).getTextContent());
        }
        if(findNode(content, "dc:source", true) != null){
            metadata.setSource((findNode(content, "dc:source", true)).getTextContent());
        }
        for(int i=0;i<findNodeList(metadataNode, "dc:rights").size();i++){
            metadata.addRight((findNodeList(metadataNode, "dc:rights")).get(i).getTextContent());
        }
        metadata.setLanguage((findNode(content, "dc:language", true)).getTextContent().toUpperCase());
        return metadata;
    }
    public Map<String, String> readSpineMap() {
        Node spineNode = findNode(getDocument(), "spine", true);
        Map<String, String> spineMap = new HashMap<>();
        
        String key = null;
        String value;
        
        if(spineNode.hasChildNodes()){
            for(int i=0;i<spineNode.getChildNodes().getLength();i++){
                Node spineElement = spineNode.getChildNodes().item(i);
                if(spineElement.getNodeType() == 1){
                    key = spineElement.getAttributes().getNamedItem("idref").getNodeValue();
                    value = (findHref(key));
                    spineMap.put(key, value);
                }
            }
        }
        return spineMap;
    }
    private String findHref(String key) {
        Node manifestNode = findNode(getDocument(), "manifest", true);
        if(manifestNode.hasChildNodes()){
            for(int i=0;i<manifestNode.getChildNodes().getLength();i++){
                Node manifestElement = manifestNode.getChildNodes().item(i);
                if((manifestElement.getNodeType() == 1) && (manifestElement.getAttributes().getNamedItem("id").getNodeValue().equals(key))){
                    return manifestElement.getAttributes().getNamedItem("href").getNodeValue();
                }
            }
        }
        return null;
    }
    public Map<String, String> readGuideMap() {
        Node guideNode = findNode(getDocument(), "guide", true);
        Map<String, String> guideMap = new HashMap<>();
        
        String key = null;
        String value;
        
        if(guideNode != null && guideNode.hasChildNodes()){
            for(int i=0;i<guideNode.getChildNodes().getLength();i++){
                Node guideElement = guideNode.getChildNodes().item(i);
                if(guideElement.getNodeType() == 1){
                    key = guideElement.getAttributes().getNamedItem("title").getNodeValue();
                    value = guideElement.getAttributes().getNamedItem("href").getNodeValue();
                    guideMap.put(key, value);
                }
            }
        }
        Set<String> guideKeys = guideMap.keySet();
        return guideMap;
    }
    public String readTextFromSpine(String selectedValue) throws IOException {
        return readTextFromFile(eBook.getSpineMap().get(selectedValue));
    }
    public String readTextFromGuide(String selectedValue) throws IOException {
        return readTextFromFile(eBook.getGuideMap().get(selectedValue));
    }
    public String readTextFromFile(String fileName) throws IOException {
        StringBuilder sb;
        try (InputStream is = zFile.getInputStream(getZipEntry(fileName))) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null){
                sb.append(line).append("\n");
            }
        }
	String htmltext = sb.toString();
        htmltext = htmltext.replaceAll("\\<.*?\\>", "");
        return htmltext;
    }
    public Document getDocument(){
        return content;
    }
    private ZipEntry getZipEntry(String fileName) throws IOException {
        ZipEntry zEntry = null;
        Enumeration zEntries = zFile.entries();
        while (zEntries.hasMoreElements()) {
            zEntry = zFile.getEntry(((ZipEntry)zEntries.nextElement()).getName());
            if(zEntry.getName().endsWith(fileName)){
                return zEntry;
            }
        }
        return null;
    }
    public Node findNode(Node root, String elementName, boolean deep) {
        //Check to see if root has any children if not return null
        if (!(root.hasChildNodes())){
            return null;
        }
        //Root has children, so continue searching for them
        Node matchingNode = null;
        String nodeName = null;
        Node child = null;

        NodeList childNodes = root.getChildNodes();
        int noChildren = childNodes.getLength();
        for (int i = 0; i < noChildren; i++) {
            if(matchingNode == null) {
                child = childNodes.item(i);
                nodeName = child.getNodeName();
                if ((nodeName != null) && (nodeName.equals(elementName))){
                    return child;
                }
                if (deep){
                    matchingNode = findNode(child, elementName, deep);
                }
            }else{
                break;
            }
        }
        return matchingNode;
    }
    public List<Node> findNodeList(Node root, String elementName){
        //Check to see if root has any children if not return null
        if (!(root.hasChildNodes())){
            return null;
        }
        List<Node> nodeList = new ArrayList<>();
        for(int i=0;i<root.getChildNodes().getLength();i++){
            Node element = root.getChildNodes().item(i);
            if (element.getNodeName().equals(elementName)){
                nodeList.add(element);
            }
        }
        return nodeList;
    }
    private void appendNode(String name, String textContent){
        Element metadataNode = (Element) findNode(content, "metadata", true);
        Element subject = content.createElement(name);
        subject.appendChild(content.createTextNode(textContent));
        metadataNode.appendChild(subject);
    }
    public void saveMetadata() throws IOException, TransformerException{
        zFile.close();
        EBookWriter.saveContentChanges(eBookPath, contentPath, content);
        zFile = new ZipFile(eBookPath);
    }
}
