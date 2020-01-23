import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class EBookReader {
    public final String path;
    private final Document content;
    
    public EBookReader(String path) throws ParserConfigurationException, IOException, SAXException{
        this.path = path;
        DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputStream is = getInput("content.opf");
        content = dBuilder.parse(is);
    }
    public Document getDocument(){
        return content;
    }
    
    public String readTextFromFile(String fileName) throws IOException {
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
    
    Metadata readMetadata() {
        Node metadataNode = (findNode(content, "metadata", true));
        Metadata metadata = new Metadata();
        metadata.setTitle((findNode(metadataNode, "dc:title", true)).getTextContent());
        metadata.setAutor((findNode(metadataNode, "dc:creator", true)).getTextContent());
        metadata.setDate((findNode(content, "dc:date", true)).getTextContent());
        
        if(findNode(metadataNode, "dc:publisher", true) != null){
            metadata.setPublisher(findNode(metadataNode, "dc:publisher", true).getTextContent());
        }
        for(int i=0;i<findNodeList(metadataNode, "dc:subject", true).size();i++){
            metadata.addSubject((findNodeList(metadataNode, "dc:subject", true)).get(i).getTextContent());
        }
        System.out.println(metadata.getPublisher());
        System.out.println(metadata.getSubjects().toString());
        return metadata;
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
                    if (deep)
                        matchingNode = findNode(child, elementName, deep);
                }else{
                    break;
                }
            }
        return matchingNode;
    }
    public List<Node> findNodeList(Node root, String elementName, boolean deep){
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
}
