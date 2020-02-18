import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class EBookReader {
    private final String eBookPath;
    private EBook eBook;
    
    public EBookReader(String eBookPath){
        this.eBookPath = eBookPath;
    }
    boolean isEBook(String path) {
        return true;
    }
    public EBook readEBook() throws IOException, ParserConfigurationException, SAXException{
        eBook = new EBook(eBookPath);
        eBook.setZipFile();
        String contentPath = getZipEntry("content.opf").toString();
        DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document content;
        try (InputStream is = eBook.getZipFile().getInputStream(getZipEntry("content.opf"))) {
            content = dBuilder.parse(is);
        }
        eBook.setContentPath(contentPath);
        eBook.setContent(content);
        eBook.setMetadata(readMetadata());
        eBook.setSpineMap(readSpineMap());
        eBook.setGuideMap(readGuideMap());
        return eBook;
    }
    private Metadata readMetadata() {
        Metadata metadata = new Metadata(EBook.findNode(eBook.getContent(), "metadata", true));
        for(int i=0;i<eBook.findNodeList("dc:creator").getLength();i++){
            metadata.addCreator((eBook.findNodeList("dc:creator")).item(i).getTextContent());
        }
        metadata.setTitle((EBook.findNode(metadata.getMetadataNode(), "dc:title", true)).getTextContent());
        for(int i=0;i<eBook.findNodeList("dc:publisher").getLength();i++){
            metadata.addPublisher((eBook.findNodeList("dc:publisher")).item(i).getTextContent());
        }
        String datetmp;
        for(int i=0;i<eBook.findNodeList("dc:date").getLength();i++){
            datetmp = (eBook.findNodeList("dc:date")).item(i).getAttributes().item(0).getTextContent();
            datetmp += ": ";
            datetmp += (eBook.findNodeList("dc:date")).item(i).getTextContent();
            metadata.addDate(datetmp);
        }
        for(int i=0;i<eBook.findNodeList("dc:subject").getLength();i++){
            metadata.addSubject((eBook.findNodeList("dc:subject")).item(i).getTextContent());
        }
        if(EBook.findNode(eBook.getContent(), "dc:source", true) != null){
            metadata.setSource((EBook.findNode(eBook.getContent(), "dc:source", true)).getTextContent());
        }
        for(int i=0;i<eBook.findNodeList("dc:rights").getLength();i++){
            metadata.addRight((eBook.findNodeList("dc:rights")).item(i).getTextContent());
        }
        metadata.setLanguage((EBook.findNode(eBook.getContent(), "dc:language", true)).getTextContent().toUpperCase());
        return metadata;
    }
    private Map<String, String> readSpineMap() {
        Node spineNode = EBook.findNode(eBook.getContent(), "spine", true);
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
        Node manifestNode = EBook.findNode(eBook.getContent(), "manifest", true);
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
    private Map<String, String> readGuideMap() {
        Node guideNode = EBook.findNode(eBook.getContent(), "guide", true);
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
    public String readTextFromFile(String fileName) throws IOException{
        StringBuilder sb;
        try (InputStream is = eBook.getZipFile().getInputStream(getZipEntry(fileName))) {
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
    private ZipEntry getZipEntry(String fileName) throws IOException {
        ZipFile zFile = eBook.getZipFile();
        ZipEntry zEntry = null;
        Enumeration zEntries = zFile.entries();
        while (zEntries.hasMoreElements()) {
            zEntry = eBook.getZipFile().getEntry(((ZipEntry)zEntries.nextElement()).getName());
            if(zEntry.getName().endsWith(fileName)){
                return zEntry;
            }
        }
        return null;
    }
}