import java.util.ArrayList;
import org.w3c.dom.Node;

class Metadata implements Cloneable {
    private Node metadataNode;
    private final ArrayList<String> creators;
    private String title;
    private final ArrayList<String> publishers;
    private final ArrayList<String> dates;
    private final ArrayList<String> subjects;
    private String source;
    private final ArrayList<String> rights;
    private String language;
    
    public Metadata(){
        this.creators = new ArrayList<>();
        this.dates = new ArrayList<>();
        this.publishers = new ArrayList<>();
        this.subjects = new ArrayList<>();
        this.rights = new ArrayList<>();
    }
    public Metadata(Node metadataNode) {
        this.metadataNode = metadataNode;
        this.creators = new ArrayList<>();
        this.dates = new ArrayList<>();
        this.publishers = new ArrayList<>();
        this.subjects = new ArrayList<>();
        this.rights = new ArrayList<>();
    }
    @Override
    protected Object clone()throws CloneNotSupportedException{  
        return super.clone();  
    }
    public Node getMetadataNode(){
        return metadataNode;
    }
    public void setCreators(ArrayList<String> creators){
        for(int i=0;i<creators.size();i++){
            this.creators.add(creators.get(i));
        }
    }
    public void addCreator(String creator){
        this.creators.add(creator);
    }
    public ArrayList<String> getCreators(){
        return this.creators;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
    public void setPublishers(ArrayList<String> publishers){
        for(int i=0;i<publishers.size();i++){
            this.publishers.add(publishers.get(i));
        }
    }
    public void addPublisher(String publisher){
        this.publishers.add(publisher);
    }
    public ArrayList<String> getPublishers(){
        return publishers;
    }
    public void setDates(ArrayList<String> dates){
        for(int i=0;i<dates.size();i++){
            this.dates.add(dates.get(i));
        }
    }
    public void addDate(String date){
        this.dates.add(date);
    }
    public ArrayList<String> getDates(){
        return dates;
    }
    public void setSubjects(ArrayList<String> subjects){
        for(int i=0;i<subjects.size();i++){
            this.subjects.add(subjects.get(i));
        }
    }
    public void addSubject(String subject){
        this.subjects.add(subject);
    }
    public ArrayList<String> getSubjects(){
        return subjects;
    }
    public void setSource(String source){
        this.source = source;
    }
    public String getSource(){
        return source;
    }
    public void setRights(ArrayList<String> rights){
        for(int i=0;i<rights.size();i++){
            this.rights.add(rights.get(i));
        }
    }
    public void addRight(String right){
        this.rights.add(right);
    }
    public ArrayList<String> getRights(){
        return rights;
    }
    public void setLanguage(String language){
        this.language = language;
    }
    public String getLanguage(){
        return language;
    }
}