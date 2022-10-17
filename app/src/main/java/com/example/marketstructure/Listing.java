package com.example.marketstructure;

public class Listing extends Textbook {
    private String listingId;
    private String sellerUsername;
    private Textbook textbook;
   /*
    private String isbn;
    private String title;
    private int edition;
    private String authors;
    private String textbookImageName;

    */
    private String listingPrice;
    /*
    private int yearPublished;
    private int numberOfPages;
    private String topicCode;
    private String topic;
     */
    private String condition;
    private String additionalDetails;
    private String listingStatus;
    private String listingLastUpdatedDate;
    /*
    public Listing(String isbn, String title, int edition, String authors, String textbookImageName,
                   String originalPrice, int yearPublished, int numberOfPages, String topicCode,
                   String topic, String listingId, String sellerUsername, Textbook textbook,
                   String listingPrice, String condition, String additionalDetails,
                   String listingStatus, String listingLastUpdatedDate) {
        super(isbn, title, edition, authors, textbookImageName, originalPrice, yearPublished, numberOfPages, topicCode, topic);
        this.listingId = listingId;
        this.sellerUsername = sellerUsername;
        this.textbook = textbook;
        this.listingPrice = listingPrice;
        this.condition = condition;
        this.additionalDetails = additionalDetails;
        this.listingStatus = listingStatus;
        this.listingLastUpdatedDate = listingLastUpdatedDate;
    }

     */

    public Listing(){
        super();

    }

    public Listing(String listingId, String sellerUsername, Textbook textbook, String listingPrice, String condition, String additionalDetails, String listingStatus, String listingLastUpdatedDate) {
        this.listingId = listingId;
        this.sellerUsername = sellerUsername;
        this.textbook = textbook;
        this.listingPrice = listingPrice;
        this.condition = condition;
        this.additionalDetails = additionalDetails;
        this.listingStatus = listingStatus;
        this.listingLastUpdatedDate = listingLastUpdatedDate;
    }
    /*
    public Listing(String isbn, String title, int edition, String authors, String textbookImageName,
                   String originalPrice, int yearPublished, int numberOfPages, String topicCode,
                   String topic, String listingId, String sellerUsername, String listingPrice,
                   String condition, String additionalDetails, String listingStatus, String listingLastUpdatedDate) {
        super(isbn, title, edition, authors, textbookImageName, originalPrice, yearPublished, numberOfPages, topicCode, topic);
        this.listingId = listingId;
        this.sellerUsername = sellerUsername;
        this.listingPrice = listingPrice;
        this.condition = condition;
        this.additionalDetails = additionalDetails;
        this.listingStatus = listingStatus;
        this.listingLastUpdatedDate = listingLastUpdatedDate;
    }

     */

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

    public String getListingPrice() {
        return listingPrice;
    }

    public void setListingPrice(String listingPrice) {
        this.listingPrice = listingPrice;
    }

    public Textbook getTextbook() {
        return textbook;
    }

    public void setTextbook(Textbook textbook) {
        this.textbook = textbook;
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
