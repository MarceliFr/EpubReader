
import java.util.ArrayList;
import java.util.List;

class Metadata {
    private List<String> creators = new ArrayList<>();
    private String title;
    private List<String> publishers = new ArrayList<>();
    private String date;
    private List<String> subjects = new ArrayList<>();
    
    public Metadata(){}
    public Metadata(List<String> creators, String title, List<String> publishers, String date, List<String> subjects){
        this.creators = creators;
        this.title = title;
        this.publishers = publishers;
        this.date = date;
        this.subjects = subjects;
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
}