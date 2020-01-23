
import java.util.ArrayList;
import java.util.List;

class Metadata {
    private String title;
    private String autor;
    private String publisher;
    private String date;
    private List<String> subjects = new ArrayList<>();
    
    public Metadata(){}
    public Metadata(String title, String autor, String publisher, String date, List<String> subjects){
        this.title = title;
        this.autor = autor;
        this.publisher = publisher;
        this.date = date;
        this.subjects = subjects;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }
    public String getAutor(){
        return autor;
    }
    public void setPublisher(String publisher){
        this.publisher = publisher;
    }
    public String getPublisher(){
        return publisher;
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