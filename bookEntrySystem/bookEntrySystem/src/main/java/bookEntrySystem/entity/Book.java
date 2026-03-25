package bookEntrySystem.entity;


public class Book {

    private int id;
    private String title;
    private int authorId;
    private String publisher;
    private int year;

    public Book() {}

    public Book(int id, String title, int authorId, String publisher, int year) {
        this.id = id;
        this.title = title;
        this.authorId = authorId;
        this.publisher = publisher;
        this.year = year;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getAuthorId() { return authorId; }
    public void setAuthorId(int authorId) { this.authorId = authorId; }

    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
}