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
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

class EBookWriter {

    static void saveContentChanges(String path, String targetPath, Document content) throws TransformerConfigurationException, IOException, TransformerException {
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