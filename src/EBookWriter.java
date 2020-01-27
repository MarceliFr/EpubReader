import java.io.IOException;
import java.io.Writer;

import java.net.URI;

import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

class EBookWriter {
    private final EBook eBook;
    
    EBookWriter(EBook eBook) {
        this.eBook = eBook;
    }
    
    public void appendNode(String nodeName, String name, String textContent){
        Node appendNode = eBook.findNode(eBook.getContent(), nodeName, true);
        Element newNode = eBook.getContent().createElement(name);
        newNode.appendChild(eBook.getContent().createTextNode(textContent));
        appendNode.appendChild(newNode);
        eBook.getContent().normalize();
        saveMetadata(eBook.getContent());
    }
    void removeNode(String parentNodeName, String textContent) {
        Node toRemoveParent = eBook.findNode(eBook.getContent(), parentNodeName, true);
        if(toRemoveParent.hasChildNodes()){
            for(int i=0;i<toRemoveParent.getChildNodes().getLength();i++){
                if((toRemoveParent.getChildNodes().item(i).getNodeType() == 1) && (toRemoveParent.getChildNodes().item(i).getTextContent().equals(textContent))){
                    toRemoveParent.removeChild(toRemoveParent.getChildNodes().item(i));
                    break;
                }
            }
        }
        eBook.getContent().normalize();
        saveMetadata(eBook.getContent());
    }
    public void saveMetadata(Document source){
        try {
            eBook.getZipFile().close();
            saveContentChanges(eBook.getPath(), eBook.getContentPath(), source);
            eBook.setZipFile();
        } catch (IOException | TransformerException ex) {
            Logger.getLogger(EBookWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void saveContentChanges(String path, String targetPath, Document content) throws IOException, TransformerException{
        DOMSource source = new DOMSource(content);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        Map<String, String> env = new HashMap<>(); 
        env.put("create", "true");
        Path p = Paths.get(path);
        URI uri = URI.create("jar:" + p.toUri());
        try (FileSystem fs = FileSystems.newFileSystem(uri, env)){
            Path nf = fs.getPath(targetPath);
            try (Writer writer = Files.newBufferedWriter(nf, StandardCharsets.UTF_8, StandardOpenOption.CREATE)) {
                StreamResult result = new StreamResult(writer);
                transformer.transform(source, result);
            }
        }
    }
}