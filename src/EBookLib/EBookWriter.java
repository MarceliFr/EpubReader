package EBookLib;

import java.io.File;
import java.io.IOException;
import java.io.Writer;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import static org.w3c.dom.Node.TEXT_NODE;

public class EBookWriter {
    private final EBook eBook;
    
    public EBookWriter(EBook eBook){
        this.eBook = eBook;
    }
    public void appendNode(Document source, String parentNodeName, String newNodeName, Map<String, String> arguments, String textContent){
        Node appendNode = eBook.findNode(source, parentNodeName, true);
        Element newNode = source.createElement(newNodeName);
        if(arguments != null){
            arguments.keySet().forEach((String key) -> {
                newNode.setAttribute(key, arguments.get(key));
            });
        }
        if(!"".equals(textContent)) {
            newNode.appendChild(source.createTextNode(textContent));
        }
        appendNode.appendChild(newNode);
        source.normalize();
    }
    public void updateNode(Document source, String parentNodeName, String nodeName, String newText) {
        if(eBook.findNode(source, nodeName, true) == null){
            appendNode(source, parentNodeName, nodeName, null, newText);
        }else{
            replaceText(eBook.findNode(source, nodeName, true), newText);
        }
    }
    private void replaceText(Node node, String val) {
        Node chld = node.getChildNodes().item(0);
        if(chld == null){
            Node textN=node.getOwnerDocument().createTextNode(val);
            node.appendChild(textN);
        }else if(chld.getNodeType() == TEXT_NODE){
            chld.setNodeValue(val);
        }      
    }
    public void removeNode(Document source, String parentNodeName, String textContent) {
        Node toRemoveParent = eBook.findNode(source, parentNodeName, true);
        if(toRemoveParent.hasChildNodes()){
            for(int i=0;i<toRemoveParent.getChildNodes().getLength();i++){
                if(toRemoveParent.getChildNodes().item(i).getTextContent().equals(textContent)){
                    toRemoveParent.removeChild(toRemoveParent.getChildNodes().item(i));
                    break;
                }
            }
        }
        source.normalize();
    }
    public void saveContentChanges(Document source) throws IOException, TransformerException{
        DOMSource fromWhere = new DOMSource(source);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        Path nf = eBook.getFileSystem().getPath(eBook.findFile("content.opf"));
        try (Writer writer = Files.newBufferedWriter(nf, StandardCharsets.UTF_8, StandardOpenOption.CREATE)) {
            StreamResult result = new StreamResult(writer);
            transformer.transform(fromWhere, result);
        }
    }
    public void appendFile(String filePath) throws IOException{
        File toCopyFile = new File(filePath);
        Path copyPath = toCopyFile.toPath();
        System.out.println(copyPath);
        String toCopyFileName = toCopyFile.getName();
        String targetPathName = eBook.findFile("content.opf");
        targetPathName = targetPathName.replace("content.opf", toCopyFileName);
        Path targetPath = eBook.getFileSystem().getPath(targetPathName);
        System.out.println(targetPath);
        Files.copy(copyPath, targetPath, StandardCopyOption.REPLACE_EXISTING);
    }
}