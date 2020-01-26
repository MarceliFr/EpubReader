import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class EBook {
    private final String path;
    private Map<String, String> spineMap = new HashMap<>();
    private Map<String, String> guideMap = new HashMap<>();
    private Metadata metadata;
    
    EBook(String path) {
        this.path = path;
    }
    public String getPath(){
        return path;
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
}