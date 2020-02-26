package EBookLib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;

public class EBookReader {
    private final EBook eBook;
    
    public EBookReader(EBook eBook) {
        this.eBook = eBook;
    }
    
    public String readTextFromSpine(String spineKey) throws IOException {
        return readTextFromFile(eBook.getSpineMap().get(spineKey));
    }
    public String readTextFromGuide(String selectedValue) throws IOException {
        return readTextFromFile(eBook.getGuideMap().get(selectedValue));
    }
    public String readTextFromFile(String fileName) throws IOException{
        StringBuilder sb;
        Path filePath = eBook.getFileSystem().getPath(eBook.findFile(fileName));
        try (InputStream is = eBook.getFileSystem().provider().newInputStream(filePath)) {
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
}