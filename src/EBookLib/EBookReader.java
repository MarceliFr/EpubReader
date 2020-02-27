package EBookLib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class EBookReader {
    private final EBook eBook;
    
    public EBookReader(EBook eBook) {
        this.eBook = eBook;
    }
    
    public String readTextFromSpine(String spineKey) throws IOException {
        return readTextFromFile(eBook.getSpineMap().get(spineKey));
    }
    public String readTextFromGuide(String selectedValue) throws IOException {
        return readTextFromFile(eBook.getGuideMap().get(selectedValue));
    }
    public String readTextFromFile(String fileName) throws IOException{
        StringBuilder sb;
        Path filePath = eBook.getFileSystem().getPath(eBook.findFile(fileName));
        try (InputStream is = eBook.getFileSystem().provider().newInputStream(filePath)) {
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
    public static Node findNodeByName(Node root, String textContent, boolean deep) {
        if (!(root.hasChildNodes())){
            return null;
        }
        Node matchingNode = null;
        String nodeName = null;
        Node child = null;

        NodeList childNodes = root.getChildNodes();
        int noChildren = childNodes.getLength();
        for (int i = 0; i < noChildren; i++) {
            if(matchingNode == null) {
                child = childNodes.item(i);
                nodeName = child.getNodeName();
                if ((nodeName != null) && (nodeName.equals(textContent))){
                    return child;
                }
                if (deep){
                    matchingNode = findNodeByName(child, textContent, deep);
                }
            }else{
                break;
            }
        }
        return matchingNode;
    }
    public static Node findNodeByText(Node root, String textContent, boolean deep) {
        if (!(root.hasChildNodes())){
            return null;
        }
        Node matchingNode = null;
        String nodeTextContent = null;
        Node child = null;

        NodeList childNodes = root.getChildNodes();
        int noChildren = childNodes.getLength();
        for (int i = 0; i < noChildren; i++) {
            if(matchingNode == null) {
                child = childNodes.item(i);
                nodeTextContent = child.getTextContent();
                if ((nodeTextContent != null) && (nodeTextContent.equals(textContent))){
                    return child;
                }
                if (deep){
                    matchingNode = findNodeByText(child, textContent, deep);
                }
            }else{
                break;
            }
        }
        return matchingNode;
    }
    public static Node findNodeByAttribute(Node root, String attributeName, String attributeValue, boolean deep) {
        if (!(root.hasChildNodes())){
            return null;
        }
        Node matchingNode = null;
        String nodeAttributeName = null;
        String nodeAttributeValue = null;
        Node child = null;

        NodeList childNodes = root.getChildNodes();
        int noChildren = childNodes.getLength();
        for (int i = 0; i < noChildren; i++) {
            if(matchingNode == null) {
                child = childNodes.item(i);
                if(child.hasAttributes()){
                    for(int j=0;j<child.getAttributes().getLength();j++){
                        nodeAttributeName = child.getAttributes().item(j).getNodeName();
                        nodeAttributeValue = child.getAttributes().item(j).getNodeValue();
                        if(nodeAttributeName.compareToIgnoreCase(attributeName) == 0 && nodeAttributeValue.compareToIgnoreCase(attributeValue) == 0){
                            return child;
                        }
                    }
                }
                if (deep){
                    matchingNode = findNodeByAttribute(child, attributeName, attributeValue, deep);
                }
            }else{
                break;
            }
        }
        return matchingNode;
    }
    public static NodeList findNodeList(Document source, String elementName){
        return source.getElementsByTagName(elementName);
    }
}