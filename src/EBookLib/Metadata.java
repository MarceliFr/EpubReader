package EBookLib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Metadata implements Cloneable {
    private final ArrayList<String> creators;
    private String title;
    private final ArrayList<String> publishers;
    private final Map<String, String> dates;
    private final ArrayList<String> subjects;
    private String source;
    private final ArrayList<String> rights;
    private String language;
    
    public Metadata(){
        this.creators = new ArrayList<>();
        this.dates = new HashMap<>();
        this.publishers = new ArrayList<>();
        this.subjects = new ArrayList<>();
        this.rights = new ArrayList<>();
    }
    @Override
    public Object clone()throws CloneNotSupportedException{  
        return super.clone();  
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
    public void addPublisher(String publisher){
        this.publishers.add(publisher);
    }
    public ArrayList<String> getPublishers(){
        return publishers;
    }
    public void addDate(String key, String value){
        this.dates.put(key, value);
    }
    public Map<String, String> getDates(){
        return dates;
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