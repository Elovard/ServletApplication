package by.tms.model;

public class Book {
    private String name;
    private String author;
    private String description;
    private double price;
    private int id;

    public Book(){
    }

    public Book(String name, String author, String description, double price) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.price = price;
    }

    public Book(String name, String author, String description, double price, int id) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.price = price;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }
}
