package EBookLib;

import java.io.File;
import java.io.IOException;
import java.io.Writer;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class EBookWriter {
    private final EBook eBook;
    
    public EBookWriter(EBook eBook){
        this.eBook = eBook;
    }
    public void appendNode(Document source, String parentNodeName, String newNodeName, Map<String, String> arguments, String textContent, boolean first){
        Node appendNode = EBookReader.findNodeByName(source, parentNodeName, true);
        Element newNode = source.createElement(newNodeName);
        if(arguments != null){
            arguments.keySet().forEach((String key) -> {
                newNode.setAttribute(key, arguments.get(key));
            });
        }
        if(!"".equals(textContent)) {
            newNode.appendChild(source.createTextNode(textContent));
        }
        if(first){
            appendNode.insertBefore(newNode, appendNode.getFirstChild());
        }else{
            appendNode.appendChild(newNode);
        }
        source.normalize();
    }
    public void updateNode(Document source, String parentNodeName, String nodeName, String newText) {
        if(EBookReader.findNodeByName(source, nodeName, true) == null){
            appendNode(source, parentNodeName, nodeName, null, newText, false);
        }else{
            replaceText(EBookReader.findNodeByName(source, nodeName, true), newText);
        }
    }
    private void replaceText(Node node, String val) {
        Node chld = node.getChildNodes().item(0);
        if(chld == null){
            Node textN=node.getOwnerDocument().createTextNode(val);
            node.appendChild(textN);
        }else if(chld.getNodeType() == org.w3c.dom.Node.TEXT_NODE){
            chld.setNodeValue(val);
        }      
    }
    public void removeNode(Document source, String textContent) {
        Node toRemoveNode = EBookReader.findNodeByText(source, textContent, true);
        Node toRemoveParent = toRemoveNode.getParentNode();
        toRemoveParent.removeChild(toRemoveNode);
        source.normalize();
    }
    public void removeNode(Document source, Node toRemoveNode) {
        Node toRemoveParent = toRemoveNode.getParentNode();
        toRemoveParent.removeChild(toRemoveNode);
        source.normalize();
    }
    public void appendToToc(Document source, String fileName, String chapterName, String navId, int playorder){
        Node navMap = EBookReader.findNodeByName(source, "navMap", true);
        Element navPoint = source.createElement("navPoint");
        navPoint.setAttribute("playOrder", String.valueOf(playorder));
        navId+= String.valueOf(playorder);
        navPoint.setAttribute("id", navId);
        Element navLabel = source.createElement("navLabel");
        navPoint.appendChild(navLabel);
        Element text = source.createElement("text");
        navLabel.appendChild(text);
        text.appendChild(source.createTextNode(chapterName));
        Element content = source.createElement("content");
        content.setAttribute("src", fileName);
        navPoint.appendChild(content);
        navMap.appendChild(navPoint);
        source.normalize();
    }
    public void saveContentChanges(Document source, String fileName) throws IOException, TransformerException{
        DOMSource fromWhere = new DOMSource(source);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        Path nf = eBook.getFileSystem().getPath(eBook.findFile(fileName));
        try (Writer writer = Files.newBufferedWriter(nf, StandardCharsets.UTF_8, StandardOpenOption.CREATE)) {
            StreamResult result = new StreamResult(writer);
            transformer.transform(fromWhere, result);
        }
    }
    public void appendFile(String filePath) throws IOException{
        File toCopyFile = new File(filePath);
        Path copyPath = toCopyFile.toPath();
        String toCopyFileName = toCopyFile.getName();
        String targetPathName = eBook.findFile("content.opf");
        targetPathName = targetPathName.replace("content.opf", toCopyFileName);
        Path targetPath = eBook.getFileSystem().getPath(targetPathName);
        Files.copy(copyPath, targetPath, StandardCopyOption.REPLACE_EXISTING);
        eBook.addFile(targetPathName);
    }
    public void deleteFile(String fileName) throws IOException {
        String filePath = null;
        for (String file : eBook.getFileList()) {
            if(file.endsWith(fileName)){
                filePath = file;
                eBook.deleteFile(fileName);
                break;
            }
        }
        Path file = eBook.getFileSystem().getPath(filePath);
        Files.delete(file.toAbsolutePath());
    }
    public void createCoverPage(int width, int height, String imageName) throws IOException, TransformerException, ParserConfigurationException {
        Path titlePath = Paths.get("cover.xhtml");
        Path titlePage = Files.createFile(titlePath);
        appendFile(titlePage.toString());
        
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document titlePageDoc = builder.newDocument();
                
        Element html = titlePageDoc.createElement("html");
        html.setAttribute("xmlns", "http://www.w3.org/1999/xhtml");
        html.setAttribute("xml:lang", "en");
        
        Element head = titlePageDoc.createElement("head");
        html.appendChild(head);

        Element title = titlePageDoc.createElement("title");
        title.setTextContent("Cover");
        head.appendChild(title);
        
        Element body = titlePageDoc.createElement("body");
        html.appendChild(body);
        
        Element div = titlePageDoc.createElement("div");
        body.appendChild(div);
        
        Element svg = titlePageDoc.createElement("svg");
        svg.setAttribute("version", "1.1");
        svg.setAttribute("xmlns", "http://www.w3.org/2000/svg");
        svg.setAttribute("xmlns:xlink", "http://www.w3.org/1999/xlink");
        svg.setAttribute("width", "100%");
        svg.setAttribute("height", "100%");
        String viewBox = "0 0 " + String.valueOf(width) + " " + String.valueOf(height);
        System.out.println(viewBox);
        svg.setAttribute("viewBox", viewBox);
        svg.setAttribute("preserveAspectRatio", "none");
        div.appendChild(svg);
        
        Element image = titlePageDoc.createElement("image");
        image.setAttribute("width", String.valueOf(width));
        image.setAttribute("height", String.valueOf(height));
        image.setAttribute("xlink:href", imageName);
        svg.appendChild(image);
        
        titlePageDoc.appendChild(html);
        saveContentChanges(titlePageDoc, "cover.xhtml");
        Files.delete(titlePath);
    }
}