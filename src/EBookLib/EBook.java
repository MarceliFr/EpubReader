package EBookLib;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipFile;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class EBook{
    private final String path;
    private ZipFile zFile;
    private String contentPath;
    private Document content;
    private Map<String, String> spineMap;
    private Map<String, String> guideMap;
    private Metadata metadata;
    
    public EBook(String path) {
        this.path = path;
        spineMap = new HashMap<>();
        guideMap = new HashMap<>();
    }
    
    public String getPath(){
        return path;
    }
    public void setContentPath(String contentPath) {
        this.contentPath = contentPath;
    }
    public String getContentPath(){
        return contentPath;
    }
    public void setContent(Document content) {
        this.content = content;
    }
    public Document getContent(){
        return content;
    }
    void openZipFile() throws IOException {
        zFile = new ZipFile(path);
    }
    public ZipFile getZipFile(){
        return zFile;
    }
    public void setMetadata(Metadata metadata){
        this.metadata = metadata;
    }
    public Metadata getMetadata(){
        return this.metadata;
    }
    public void setSpineMap(Map<String, String> spineMap) {
        this.spineMap = spineMap;
    }
    public Map<String, String> getSpineMap(){
        return spineMap;
    }
    public void setGuideMap(Map<String, String> guideMap) {
        this.guideMap = guideMap;
    }
    public Map<String, String> getGuideMap(){
        return guideMap;
    }
    public void close() throws IOException {
        zFile.close();
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
    public NodeList findNodeList(String elementName){
        return content.getElementsByTagName(elementName);
    }
}