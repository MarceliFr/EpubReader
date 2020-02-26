package EBookLib;

import java.io.IOException;
import java.io.Writer;

import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

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
    private final Document source;
    private final EBook eBook;
    
    public EBookWriter(Document source, EBook eBook){
        this.eBook = eBook;
        this.source = source;
    }
    public void appendNode(String parentNodeName, String newNodeName, String newNodeArgument, String newNodeArgumentValue, String newNodetextContent){
        Node appendNode = eBook.findNode(source, parentNodeName, true);
        Element newNode = source.createElement(newNodeName);
        if(!("".equals(newNodeArgument))){
            newNode.setAttribute(newNodeArgument, newNodeArgumentValue);
        }
        newNode.appendChild(source.createTextNode(newNodetextContent));
        appendNode.appendChild(newNode);
        source.normalize();
    }
    public void updateNode(String parentNodeName, String nodeName, String newText) {
        if(eBook.findNode(source, nodeName, true) == null){
            appendNode(parentNodeName, nodeName, "", "", newText);
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
    public void removeNode(String parentNodeName, String textContent) {
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
    public void saveContentChanges() throws IOException, TransformerException{
        eBook.getZipFile().close();
        DOMSource fromWhere = new DOMSource(source);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        Path p = Paths.get(eBook.getPath());
        try (FileSystem fs = FileSystems.newFileSystem(p, null)){
            Path nf = fs.getPath(eBook.getContentPath());
            try (Writer writer = Files.newBufferedWriter(nf, StandardCharsets.UTF_8, StandardOpenOption.CREATE)) {
                StreamResult result = new StreamResult(writer);
                transformer.transform(fromWhere, result);
            }
        }
        eBook.openZipFile();
    }
    public void appendFile(){
        
    }
}