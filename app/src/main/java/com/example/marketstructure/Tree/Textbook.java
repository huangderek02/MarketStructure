package com.example.marketstructure.Tree;

public class Textbook {
    String listingId;
    String sellerUsername;
    String textbookImageURL;
    int price;
    String ISBN;
    String title;
    int edition;
    String author;
    int yearPublished;
    int numberOfPages;
    String topicCode;
    String topic;
    String condition;
    String additionalDetails;
    String listingStatus;
    String listingLastUpdatedDate;


    public Textbook(String listingId, String sellerUsername, String textbookImageURL, int price,
                    String ISBN, String title, int edition, String author, int yearPublished, int numberOfPages,
                    String topicCode, String topic, String condition, String additionalDetails,
                    String listingStatus, String listingLastUpdatedDate){

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title.toLowerCase().trim();
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
