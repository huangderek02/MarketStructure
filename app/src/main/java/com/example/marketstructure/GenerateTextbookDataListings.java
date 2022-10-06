package com.example.marketstructure;

import java.util.ArrayList;
import java.util.List;

public class GenerateTextbookDataListings extends ListingTextbookData {
    public static List<Textbook> listings;
    public GenerateTextbookDataListings() {
        listings = new ArrayList<>();
    }

    public static String getRandomSellerUsername() {
        String randomSellerUsername;
        String[] sellerUsername = sellerUsernames;
        int index = (int) (Math.random() * sellerUsernames.length);
        randomSellerUsername = sellerUsername[index];
        return randomSellerUsername;
    }

    public static Textbook getRandomTextbook() {
        Textbook randomTextbook;
        int index = (int) (Math.random() * textbooks.size());
        randomTextbook = textbooks.get(index);
        return randomTextbook;
    }

    public static String getRandomCondition() {
        String randomCondition;
        int index = (int) (Math.random() * conditions.length);
        randomCondition = conditions[index];
        return randomCondition;
    }

    public static String getRandomListingStatus() {
        String randomListingStatus;
        int index = (int) (Math.random() * listingStatuses.length);
        randomListingStatus = listingStatuses[index];
        return randomListingStatus;
    }

    public static String getRandomAdditionalDetails() {
        String randomAdditionalDetails;
        if (getRandomCondition().equals("New")) {
            int index = (int) (Math.random() * additionalDetailsNew.length);
            randomAdditionalDetails = additionalDetailsNew[index];
            return randomAdditionalDetails;
        } else {
            int index = (int) (Math.random() * additionalDetailsUsed.length);
            randomAdditionalDetails = additionalDetailsUsed[index];
            return randomAdditionalDetails;
        }
    }

    public static double getRandomPrice(double minPrice, double maxPrice) {
        double price = Math.random() * (maxPrice - minPrice + 1) + minPrice;
        if (getRandomCondition().equals("New")) {
            return price - (price * 0.10);
        } else if (getRandomCondition().equals("Used")
                && getRandomAdditionalDetails().equals("Textbook has clear contact cover")
                || getRandomAdditionalDetails().equals("Textbook ebook code has been used")
                || getRandomAdditionalDetails().equals("Textbook is in good condition, only used for 6 months")
                || getRandomAdditionalDetails().equals("N/A")
                || getRandomAdditionalDetails().equals("Textbook is in good condition, only used for 1 year")) {
            return price - (price * 0.20);
        } else {
            return price - (price * 0.30);
        }
    }
}
