import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import static org.w3c.dom.Node.ELEMENT_NODE;
import org.xml.sax.SAXException;

class EBook {
    //private final Book publikacja;
    Document content;
    private final String path;
    private final Map<String, String> spineMap = new HashMap<>();
    private final Map<String, String> guideMap = new HashMap<>();
    private final Metadata metadata;
       
    public EBook(String path) throws FileNotFoundException, IOException, ParserConfigurationException {
        //EpubReader epb = new EpubReader();
        //publikacja = epb.readEpub(new FileInputStream(path));
        this.path = path;
        
        DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputStream is = getInput("content.opf");
        try {
            content = dBuilder.parse(is);
        } catch (SAXException ex) {
            Logger.getLogger(EBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        metadata = readMetadata();
    }

    public List<String> wypelnij_plikiTree() throws IOException {
        return null;
    }
    
    public Set<String> wypelnij_spine() {
        Node spineNode = findNode(content, "spine", true);
                
        String key = null;
        String value;
        
        if(spineNode.hasChildNodes()){
            for(int i=0;i<spineNode.getChildNodes().getLength();i++){
                Node spineElement = spineNode.getChildNodes().item(i);
                if(spineElement.getNodeType() == ELEMENT_NODE){
                    key = spineElement.getAttributes().getNamedItem("idref").getNodeValue();
                    value = (findHref(key));
                    spineMap.put(key, value);
                }
            }
        }
        Set<String> spineKeys = spineMap.keySet();
        return spineKeys;
    }
    private String findHref(String key) {
        Node manifestNode = findNode(content, "manifest", true);
        if(manifestNode.hasChildNodes()){
            for(int i=0;i<manifestNode.getChildNodes().getLength();i++){
                Node manifestElement = manifestNode.getChildNodes().item(i);
                if((manifestElement.getNodeType() == ELEMENT_NODE) && (manifestElement.getAttributes().getNamedItem("id").getNodeValue().equals(key))){
                    return manifestElement.getAttributes().getNamedItem("href").getNodeValue();
                }
            }
        }
        return null;
    }   
    public Set<String> wypelnij_guide() {
        Node guideNode = findNode(content, "guide", true);
                
        String key = null;
        String value;
        
        if(guideNode.hasChildNodes()){
            for(int i=0;i<guideNode.getChildNodes().getLength();i++){
                Node guideElement = guideNode.getChildNodes().item(i);
                if(guideElement.getNodeType() == ELEMENT_NODE){
                    key = guideElement.getAttributes().getNamedItem("title").getNodeValue();
                    value = guideElement.getAttributes().getNamedItem("href").getNodeValue();
                    guideMap.put(key, value);
                }
            }
        }
        Set<String> guideKeys = guideMap.keySet();
        return guideKeys;
    }
    public String readTextFromSpine(Object selectedValue) throws IOException {
        return readTextFromFile(spineMap.get(selectedValue));
    }
    public String readTextFromGuide(Object selectedValue) throws IOException {
        return readTextFromFile(guideMap.get(selectedValue));
    }
    private String readTextFromFile(String fileName) throws IOException {
        InputStream is = getInput(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null){
            sb.append(line).append("\n");
        }
	String htmltext = sb.toString();
        htmltext = htmltext.replaceAll("\\<.*?\\>", "");
        return htmltext;
    }
    public String readMetadata(String data) throws IOException, ParserConfigurationException, SAXException{
        String find = (findNode(content, data, true)).getTextContent();
        return find;
    }
    private InputStream getInput(String fileName) throws IOException {
        ZipFile zFile = new ZipFile(path);
        ZipEntry zEntry = null;
        Enumeration zEntries = zFile.entries();
        while (zEntries.hasMoreElements()) {
            zEntry = zFile.getEntry(((ZipEntry)zEntries.nextElement()).getName());
            if(zEntry.getName().endsWith(fileName)){
                InputStream is = zFile.getInputStream(zEntry);
                return is;
            }
        }
        return null;
    }
    private Node findNode(Node root, String elementName, boolean deep) {
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
                    if (deep)
                        matchingNode = findNode(child, elementName, deep);
                }else{
                    break;
                }
            }
        return matchingNode;
    }
    public void close() {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private Metadata readMetadata() {
        return null;
    }
}