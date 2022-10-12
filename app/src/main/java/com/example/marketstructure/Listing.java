package com.example.marketstructure;

public class Listing extends Textbook {
    private String listingId;
    private String sellerUsername;
    private String isbn;
    private String title;
    private int edition;
    private String authors;
    private String textbookImageURL;
    private double price;
    private int yearPublished;
    private int numberOfPages;
    private String topicCode;
    private String topic;
    private String condition;
    private String additionalDetails;
    private String listingStatus;
    private String listingLastUpdatedDate;

    public Listing(String isbn, String title, int edition, String authors, String textbookImageURL, double price, int yearPublished, int numberOfPages, String topicCode, String topic) {
        super(isbn, title, edition, authors, textbookImageURL, price, yearPublished, numberOfPages, topicCode, topic);
    }


    public String getListingId() {
        return listingId;
    }

    public void setListingId(String listingId) {
        this.listingId = listingId;
    }

    public String getSellerUsername() {
        return sellerUsername;
    }

    public void setSellerUsername(String sellerUsername) {
        this.sellerUsername = sellerUsername;
    }

    public String getTextbookImageURL() {
        return textbookImageURL;
    }

    public void setTextbookImageURL(String textbookImageURL) {
        this.textbookImageURL = textbookImageURL;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String ISBN) {
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

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getAdditionalDetails() {
        return additionalDetails;
    }

    public void setAdditionalDetails(String additionalDetails) {
        this.additionalDetails = additionalDetails;
    }

    public String getListingStatus() {
        return listingStatus;
    }

    public void setListingStatus(String listingStatus) {
        this.listingStatus = listingStatus;
    }

    public String getListingLastUpdatedDate() {
        return listingLastUpdatedDate;
    }

    public void setListingLastUpdatedDate(String listingLastUpdatedDate) {
        this.listingLastUpdatedDate = listingLastUpdatedDate;
    }

}
