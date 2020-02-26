package EBookLib;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class EBook{
    private final String path;
    private FileSystem fileSystem;
    private final ArrayList<String> fileList;
    private Document content;
    private final Map<String, String> spineMap;
    private final Map<String, String> guideMap;
    private Metadata metadata;
        
    public EBook(String path) {
        this.path = path;
        fileList = new ArrayList<>();
        spineMap = new HashMap<>();
        guideMap = new HashMap<>();
    }
    
    public String getPath(){
        return path;
    }
    public void setFileSystem(FileSystem fileSystem){
        this.fileSystem = fileSystem;
    }
    public FileSystem getFileSystem(){
        return fileSystem;
    }
    public void addFile(String filePath){
        fileList.add(filePath);
    }
    public String findFile(String fileName){
        String filePath = null;
        for (String file : fileList) {
            if(file.endsWith(fileName)){
                filePath = file;
                break;
            }
        }
        return filePath;
    }
    public void setContent(Document content) {
        this.content = content;
    }
    public Document getContent(){
        return content;
    }
    public void setMetadata(Metadata metadata){
        this.metadata = metadata;
    }
    public Metadata getMetadata(){
        return this.metadata;
    }
    public void addToSpineMap(String key, String value) {
        spineMap.put(key, value);
    }
    public Map<String, String> getSpineMap(){
        return spineMap;
    }
    public void addToGuideMap(String key, String value) {
        guideMap.put(key, value);
    }
    public Map<String, String> getGuideMap(){
        return guideMap;
    }
    public boolean hasCover(){
        boolean isCover = false;
        for(int i=0;i<content.getElementsByTagName("item").getLength();i++){
            for(int j=0;j<content.getElementsByTagName("item").item(i).getAttributes().getLength();j++){
                if(content.getElementsByTagName("item").item(i).getAttributes().item(j).getTextContent().toLowerCase().contains("cover")){
                    isCover = true;
                }
            }
            if(isCover == true){
                break;
            }
        }
        return isCover;
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
    public void close() throws IOException{
        fileSystem.close();
        fileList.removeAll(fileList);
        spineMap.clear();
        guideMap.clear();
    }
}