package com.example.marketstructure;

import java.io.Serializable;

public class Textbook implements Serializable {
    private String isbn;
    private String title;
    private int edition;
    private String authors;
    private String textbookImageName;
    private String originalPrice;
    private int yearPublished;
    private int numberOfPages;
    private String topicCode;
    private String topic;

    public Textbook(String isbn, String title, int edition, String authors, String textbookImageName, String originalPrice, int yearPublished, int numberOfPages, String topicCode, String topic) {
        this.isbn = isbn;
        this.title = title;
        this.edition = edition;
        this.authors = authors;
        this.textbookImageName = textbookImageName;
        this.originalPrice = originalPrice;
        this.yearPublished = yearPublished;
        this.numberOfPages = numberOfPages;
        this.topicCode = topicCode;
        this.topic = topic;
    }

    public Textbook() {
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

    public String getTextbookImageName() {
        return textbookImageName;
    }

    public void setTextbookImageName(String textbookImageName) {
        this.textbookImageName = textbookImageName;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
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
