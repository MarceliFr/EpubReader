package EBookLib;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class EBookFactory {    
    public EBookFactory(){}
    
    public boolean isEBook(String path) throws IOException {
        File testFile = new File(path);
        String mimetypeContent;
        try (FileSystem fileSystem = FileSystems.newFileSystem(testFile.toPath(), null)) {
            Path content = fileSystem.getPath("/mimetype");
            try (InputStream is = fileSystem.provider().newInputStream(content)){
                mimetypeContent = inputStreamToString(is);
            }
        }
        return mimetypeContent.equals("application/epub+zip");
    }
    public EBook readEBook(String eBookPath) throws ParserConfigurationException, IOException, SAXException{
        EBook eBook;
        eBook = new EBook(eBookPath);
        File testFile = new File(eBookPath);
        FileSystem fileSystem = FileSystems.newFileSystem(testFile.toPath(), null);
        eBook.setFileSystem(fileSystem);
        Path root = fileSystem.getPath("/");
        fillFiles(eBook, root);
        
        DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document content;
        Path contentPath = fileSystem.getPath(eBook.findFile("content.opf"));
        try (InputStream is = fileSystem.provider().newInputStream(contentPath)){
            content = dBuilder.parse(is);
        }
        Document toc;
        Path tocPath = fileSystem.getPath(eBook.findFile("toc.ncx"));
        try (InputStream is = fileSystem.provider().newInputStream(tocPath)){
            toc = dBuilder.parse(is);
        }
        eBook.setContent(content);
        eBook.setToc(toc);
        int playorder = 0;
        NodeList playList = EBookReader.findNodeList(toc, "navPoint");
        for(int i=0;i<playList.getLength();i++){
            Node play = playList.item(i).getAttributes().getNamedItem("playOrder");
            int tmpPlay = Integer.parseInt(play.getNodeValue());
            if(tmpPlay > playorder){
                playorder = tmpPlay;
            }
        }
        String navId = playList.item(0).getAttributes().getNamedItem("id").getNodeValue();
        navId = navId.substring(0, navId.indexOf("-")+1);
        System.out.println(navId);
        eBook.setPlayOrder(playorder);
        eBook.setMetadata(readMetadata(eBook.getContent()));
        fillSpineMap(eBook);
        fillGuideMap(eBook);
        return eBook;
    }
    private Metadata readMetadata(Document content){
        Metadata metadata = new Metadata();
        for(int i=0;i<EBookReader.findNodeList(content, "dc:creator").getLength();i++){
            metadata.addCreator((EBookReader.findNodeList(content, "dc:creator")).item(i).getTextContent());
        }
        metadata.setTitle((EBookReader.findNodeByName(content, "dc:title", true)).getTextContent());
        for(int i=0;i<EBookReader.findNodeList(content, "dc:publisher").getLength();i++){
            metadata.addPublisher((EBookReader.findNodeList(content, "dc:publisher")).item(i).getTextContent());
        }
        String key = null;
        String value;
        for(int i=0;i<EBookReader.findNodeList(content, "dc:date").getLength();i++){
            key = (EBookReader.findNodeList(content, "dc:date")).item(i).getAttributes().item(0).getTextContent();
            value = EBookReader.findNodeList(content, "dc:date").item(i).getTextContent();
            metadata.addDate(key, value);
        }
        for(int i=0;i<EBookReader.findNodeList(content, "dc:subject").getLength();i++){
            metadata.addSubject((EBookReader.findNodeList(content, "dc:subject")).item(i).getTextContent());
        }
        if(EBookReader.findNodeByName(content, "dc:source", true) != null){
            metadata.setSource((EBookReader.findNodeByName(content, "dc:source", true)).getTextContent());
        }
        for(int i=0;i<EBookReader.findNodeList(content, "dc:rights").getLength();i++){
            metadata.addRight((EBookReader.findNodeList(content, "dc:rights")).item(i).getTextContent());
        }
        metadata.setLanguage((EBookReader.findNodeByName(content, "dc:language", true)).getTextContent().toUpperCase());
        return metadata;
    }
    public void fillFiles(EBook eBook, Path root) throws IOException{
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(root)) {
            for (Path path : stream) {
                if(path.toString().endsWith("/")){
                    fillFiles(eBook, path);
                }else{
                    eBook.addFile(path.toString());
                }
            }
        }
    }
    private void fillSpineMap(EBook eBook) {
        Node spineNode = EBookReader.findNodeByName(eBook.getContent(), "spine", true);
        
        String key = null;
        String value;
        
        if(spineNode.hasChildNodes()){
            for(int i=0;i<spineNode.getChildNodes().getLength();i++){
                Node spineElement = spineNode.getChildNodes().item(i);
                if(spineElement.getNodeType() == 1){
                    key = spineElement.getAttributes().getNamedItem("idref").getNodeValue();
                    value = EBookReader.findNodeByAttribute(eBook.getContent(), "id", key, true).getAttributes().getNamedItem("href").getNodeValue();
                    eBook.addToSpineMap(key, value);
                }
            }
        }
    }
    private void fillGuideMap(EBook eBook) {
        Node guideNode = EBookReader.findNodeByName(eBook.getContent(), "guide", true);
        Map<String, String> guideMap = new HashMap<>();
        
        String key = null;
        String value;
        
        if(guideNode != null && guideNode.hasChildNodes()){
            for(int i=0;i<guideNode.getChildNodes().getLength();i++){
                Node guideElement = guideNode.getChildNodes().item(i);
                if(guideElement.getNodeType() == 1){
                    key = guideElement.getAttributes().getNamedItem("title").getNodeValue();
                    value = guideElement.getAttributes().getNamedItem("href").getNodeValue();
                    eBook.addToGuideMap(key, value);
                }
            }
        }
    }
    public static String inputStreamToString(InputStream inputStream) {
        //In Java 9 use inputStream.readAllBytes()
        return new Scanner(inputStream, "UTF-8").useDelimiter("\\A").next();
    }
}