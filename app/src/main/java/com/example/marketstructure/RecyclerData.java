package com.example.marketstructure;

public class RecyclerData {
    private final String sellerUsername;
    private final String textbookImageURL;
    private final String edition;
    private final String yearPublished;
    private final String isbn;
    private final String price;

    public RecyclerData(String sellerUsernameID, String textbookImageID, String sellerUsername, String textbookImageURL, String edition, String yearPublished, String isbn, String price) {
        this.sellerUsername = sellerUsername;
        this.textbookImageURL = textbookImageURL;
        this.edition = edition;
        this.yearPublished = yearPublished;
        this.isbn = isbn;
        this.price = price;
    }

    public String getSellerUsername() {
        return sellerUsername;
    }

    public String getTextbookImageURL() {
        return textbookImageURL;
    }

    public String getEdition() {
        return edition;
    }

    public String getYearPublished() {
        return yearPublished;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPrice() {
        return price;
    }


}
