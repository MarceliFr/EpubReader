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

class EBookWriter {
    private final Document source;
    
    EBookWriter(Document source){
        this.source = source;
    }
    
    void appendNode(String parentNodeName, String newNodeName, String newNodeArgument, String newNodeArgumentValue, String newNodetextContent){
        Node appendNode = EBook.findNode(source, parentNodeName, true);
        Element newNode = source.createElement(newNodeName);
        if(!("".equals(newNodeArgument))){
            newNode.setAttribute(newNodeArgument, newNodeArgumentValue);
        }
        newNode.appendChild(source.createTextNode(newNodetextContent));
        appendNode.appendChild(newNode);
        source.normalize();
    }
    void updateNode(String parentNodeName, String nodeName, String newText) {
        if(EBook.findNode(source, nodeName, true) == null){
            appendNode(parentNodeName, nodeName, "", "", newText);
        }else{
            replaceText(EBook.findNode(source, nodeName, true), newText);
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
    void removeNode(String parentNodeName, String textContent) {
        Node toRemoveParent = EBook.findNode(source, parentNodeName, true);
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
    void saveContentChanges(String path, String targetPath, Document content) throws IOException, TransformerException{
        DOMSource fromWhere = new DOMSource(content);
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
                transformer.transform(fromWhere, result);
            }
        }
    }
}