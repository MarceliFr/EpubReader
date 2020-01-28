import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipFile;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class EBook{
    private final String path;
    private ZipFile zFile;
    private String contentPath;
    private Document content;
    private Map<String, String> spineMap = new HashMap<>();
    private Map<String, String> guideMap = new HashMap<>();
    private Metadata metadata;
    
    EBook(String path) {
        this.path = path;
    }
    
    public String getPath(){
        return path;
    }
    void setContentPath(String contentPath) {
        this.contentPath = contentPath;
    }
    public String getContentPath(){
        return contentPath;
    }
    void setContent(Document content) {
        this.content = content;
    }
    public Document getContent(){
        return content;
    }
    void setZipFile() throws IOException {
        zFile = new ZipFile(path);
    }
    public ZipFile getZipFile(){
        return zFile;
    }
    public void setMetadata(Metadata metadata){
        this.metadata = metadata;
    }
    public Metadata getMetadata(){
        return metadata;
    }
    public void setSpineMap(Map<String, String> spineMap) {
        this.spineMap = spineMap;
    }
    public Map<String, String> getSpineMap(){
        return spineMap;
    }
    public Set<String> getSpineKeys(){
        Set<String> spineKeys = spineMap.keySet();
        return spineKeys;
    }
    public void setGuideMap(Map<String, String> guideMap) {
        this.guideMap = guideMap;
    }
    public Map<String, String> getGuideMap(){
        return guideMap;
    }
    public Set<String> getGuideKeys(){
        Set<String> guideKeys = guideMap.keySet();
        return guideKeys;
    }
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static Node findNode(Node root, String elementName, boolean deep) {
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
}