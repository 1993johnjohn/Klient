package models;

public class Book {

    private String title;
    private int version;
    private long ISBN;
    private double priceAB;
    private double priceSAXO;
    private double priceCDON;
    private String publisher;
    private String author;
    private int bookID;

    public Book(){

    }

    public Book(String title, int version, long ISBN, double priceAB, double priceSAXO, double priceCDON, String publisher, String author, int bookID) {
        this.title = title;
        this.version = version;
        this.ISBN = ISBN;
        this.priceAB = priceAB;
        this.priceSAXO = priceSAXO;
        this.priceCDON = priceCDON;
        this.publisher = publisher;
        this.author = author;
        this.bookID = bookID;
    }

    public Book(String title, int version, long ISBN, double priceAB, double priceSAXO, double priceCDON, String publisher, String author) {
        this.title = title;
        this.version = version;
        this.ISBN = ISBN;
        this.priceAB = priceAB;
        this.priceSAXO = priceSAXO;
        this.priceCDON = priceCDON;
        this.publisher = publisher;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public double getPriceAB() {
        return priceAB;
    }

    public void setPriceAB(double priceAB) {
        this.priceAB = priceAB;
    }

    public double getPriceSAXO() {
        return priceSAXO;
    }

    public void setPriceSAXO(double priceSAXO) {
        this.priceSAXO = priceSAXO;
    }

    public double getPriceCDON() {
        return priceCDON;
    }

    public void setPriceCDON(double priceCDON) {
        this.priceCDON = priceCDON;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }
}
