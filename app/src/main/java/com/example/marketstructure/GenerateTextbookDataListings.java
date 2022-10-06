package com.example.marketstructure;

import java.util.ArrayList;
import java.util.List;

public class GenerateTextbookDataListings extends ListingTextbookData {
    public static List<Textbook> listings;
    public GenerateTextbookDataListings() {
        listings = new ArrayList<>();
    }

    public static double getRandomPrice(double minPrice, double maxPrice) {
        double price = Math.random() * (maxPrice - minPrice + 1) + minPrice;
        return price;
    }

    public static Textbook getRandomTextbook() {
        Textbook randomTextbook;
        ArrayList<Textbook> textbooks = ListingTextbookData.textbooks;
        int index = (int) (Math.random() * textbooks.size());
        randomTextbook = textbooks.get(index);
        return randomTextbook;
    }
}
