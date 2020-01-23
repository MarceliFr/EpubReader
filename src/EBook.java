import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;

import static org.w3c.dom.Node.ELEMENT_NODE;
import org.xml.sax.SAXException;

class EBook {
    //private final Book publikacja;
    private final EBookReader eBookReader;
    private final Map<String, String> spineMap = new HashMap<>();
    private final Map<String, String> guideMap = new HashMap<>();
    Metadata metadata;
      
    public EBook(String path) throws FileNotFoundException, IOException, ParserConfigurationException, SAXException {
        //EpubReader epb = new EpubReader();
        //publikacja = epb.readEpub(new FileInputStream(path));
        eBookReader = new EBookReader(path);
        metadata = eBookReader.readMetadata();
    }
    public Metadata getMetadata(){
        return metadata;
    }
    public List<String> wypelnij_plikiTree() throws IOException {
        return null;
    }
    public Set<String> wypelnij_spine() {
        Node spineNode = eBookReader.findNode(eBookReader.getDocument(), "spine", true);
        
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
        Node manifestNode = eBookReader.findNode(eBookReader.getDocument(), "manifest", true);
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
        Node guideNode = eBookReader.findNode(eBookReader.getDocument(), "guide", true);
        
        String key = null;
        String value;
        
        if(guideNode != null && guideNode.hasChildNodes()){
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
    public String readTextFromSpine(String selectedValue) throws IOException {
        return eBookReader.readTextFromFile(spineMap.get(selectedValue));
    }
    public String readTextFromGuide(String selectedValue) throws IOException {
        return eBookReader.readTextFromFile(guideMap.get(selectedValue));
    }
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}