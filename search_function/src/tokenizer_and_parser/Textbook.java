package tokenizer_and_parser;


public class Textbook {
    private String isbn;
    private String title;
    private int edition;
    private String authors;
    private String textbookImageURL;
    private double originalPrice;
    private int yearPublished;
    private int numberOfPages;
    private String topicCode;
    private String topic;

    public Textbook(String isbn, String title, int edition, String authors, String textbookImageURL, double originalPrice, int yearPublished, int numberOfPages, String topicCode, String topic) {
        this.isbn = isbn;
        this.title = title;
        this.edition = edition;
        this.authors = authors;
        this.textbookImageURL = textbookImageURL;
        this.originalPrice = originalPrice;
        this.yearPublished = yearPublished;
        this.numberOfPages = numberOfPages;
        this.topicCode = topicCode;
        this.topic = topic;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getTextbookImageURL() {
        return textbookImageURL;
    }

    public void setTextbookImageURL(String textbookImageURL) {
        this.textbookImageURL = textbookImageURL;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getTopicCode() {
        return topicCode;
    }

    public void setTopicCode(String topicCode) {
        this.topicCode = topicCode;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}


