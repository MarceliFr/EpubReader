package EBookLib;

import java.io.IOException;
import java.nio.file.FileSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Document;

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
    public void deleteFile(String fileName){
        for (String file : fileList) {
            if(file.endsWith(fileName)){
                fileList.remove(file);
                break;
            }
        }
    }
    public ArrayList<String> getFileList(){
        return fileList;
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
        return (EBookReader.findNodeByAttribute(content, "id", "cover", true) != null);
    }
    public void close() throws IOException{
        fileSystem.close();
        fileList.removeAll(fileList);
        spineMap.clear();
        guideMap.clear();
    }

    void deleteFileFromList(String fileName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}