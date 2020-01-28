import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;

class Metadata {
    private Node metadataNode;
    private List<String> creators;
    private String title;
    private List<String> publishers = new ArrayList<>();
    private String date;
    private List<String> subjects = new ArrayList<>();
    private String source;
    private List<String> rights = new ArrayList<>();
    private String language;
    
    public Metadata(){
        this.creators = new ArrayList<>();
    }

    public Metadata(Node metadataNode, List<String> creators, String title, List<String> publishers, String date,  List<String> subjects, String source, List<String> rights, String language){
        this.metadataNode = metadataNode;
        this.creators = new ArrayList<>(creators);
        this.title = title;
        this.publishers = publishers;
        this.date = date;
        this.subjects = subjects;
        this.source = source;
        this.rights = rights;
        this.language = language;
    }
    
    Metadata(Node metadataNode) {
        this.metadataNode = metadataNode;
    }
    public Node getMetadataNode(){
        return metadataNode;
    }
    public void setCreators(List<String> creators){
        this.creators = creators;
    }
    public void addCreator(String creator){
        creators.add(creator);
    }
    public List<String> getCreators(){
        return creators;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
    public void setPublishers(List<String> publishers){
        this.publishers = publishers;
    }
    public void addPublisher(String publisher){
        publishers.add(publisher);
    }
    public List<String> getPublishers(){
        return publishers;
    }
    public void setDate(String date){
        this.date = date;
    }
    public String getDate(){
        return date;
    }
    public void setSubjects(List<String> subjects){
        this.subjects = subjects;
    }
    public void addSubject(String subject){
        subjects.add(subject);
    }
    public List<String> getSubjects(){
        return subjects;
    }
    public void setSource(String source){
        this.source = source;
    }
    public String getSource(){
        return source;
    }
    public void setRights(List<String> rights){
        this.rights = rights;
    }
    public void addRight(String right){
        rights.add(right);
    }
    public List<String> getRights(){
        return rights;
    }
    public void setLanguage(String language){
        this.language = language;
    }
    public String getLanguage(){
        return language;
    }
}