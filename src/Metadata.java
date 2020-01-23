class Metadata {
    private String title;
    private String autor;
    private String publisher;
    private String date;
    
    public Metadata(){}
    public Metadata(String title, String autor, String publisher, String date){
        this.title = title;
        this.autor = autor;
        this.publisher = publisher;
        this.date = date;
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
}