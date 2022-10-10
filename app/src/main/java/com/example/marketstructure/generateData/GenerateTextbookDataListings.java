package com.example.marketstructure.generateData;

import com.example.marketstructure.Textbook;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class GenerateTextbookDataListings {
    public static List<Textbook> listings;
    public GenerateTextbookDataListings() {
        listings = new ArrayList<>();
    }

    public static String getRandomSellerUsername() {
        String randomSellerUsername;
        String[] sellerUsername = ListingTextbookData.sellerUsernames;
        int index = (int) (Math.random() * ListingTextbookData.sellerUsernames.length);
        randomSellerUsername = sellerUsername[index];
        return randomSellerUsername;
    }

    public static Textbook getRandomTextbook() {
        Textbook randomTextbook;
        int index = (int) (Math.random() * ListingTextbookData.textbooks.size());
        randomTextbook = ListingTextbookData.textbooks.get(index);
        return randomTextbook;
    }

    public static String getRandomCondition() {
        String randomCondition;
        int index = (int) (Math.random() * ListingTextbookData.conditions.length);
        randomCondition = ListingTextbookData.conditions[index];
        return randomCondition;
    }

    public static String getRandomListingStatus() {
        String randomListingStatus;
        int index = (int) (Math.random() * ListingTextbookData.listingStatuses.length);
        randomListingStatus = ListingTextbookData.listingStatuses[index];
        return randomListingStatus;
    }

    public static String getRandomAdditionalDetails() {
        String randomAdditionalDetails;
        if (getRandomCondition().equals("New")) {
            int index = (int) (Math.random() * ListingTextbookData.additionalDetailsNew.length);
            randomAdditionalDetails = ListingTextbookData.additionalDetailsNew[index];
            return randomAdditionalDetails;
        } else if (getRandomCondition().equals("Used - Good")) {
            int index = (int) (Math.random() * ListingTextbookData.additionalDetailsUsedGood.length);
            randomAdditionalDetails = ListingTextbookData.additionalDetailsUsedGood[index];
            return randomAdditionalDetails;
        } else {
            int index = (int) (Math.random() * ListingTextbookData.additionalDetailsUsedWorn.length);
            randomAdditionalDetails = ListingTextbookData.additionalDetailsUsedWorn[index];
            return randomAdditionalDetails;
        }
    }

    /* Generate a random price for textbook where original textbook price is reduced by 5% - 30%
        depending on the condition of the textbook. The poorer the condition, the higher reduction
        in price.
     */
    public static double getRandomPrice(double minPrice, double maxPrice) {
        double price = Math.random() * (maxPrice - minPrice + 1) + minPrice;
        if (getRandomCondition().equals("New")
                && getRandomAdditionalDetails().equals("Textbook is still in original packaging")
                || getRandomAdditionalDetails().equals("Textbook includes ebook code")) {
            return price - (price * 0.05);
        } else if (getRandomCondition().equals("New")
                && getRandomAdditionalDetails().equals("Textbook ebook code has been used")) {
            return price - (price * 0.10);
        } else if (getRandomCondition().equals("Good")
                && getRandomAdditionalDetails().equals("Textbook has clear contact cover")
                || getRandomAdditionalDetails().equals("Textbook ebook code has been used")
                || getRandomAdditionalDetails().equals("Textbook is in good condition, used for 6 months")
                || getRandomAdditionalDetails().equals("N/A")
                || getRandomAdditionalDetails().equals("Textbook is in good condition, used for 1 year")) {
            return price - (price * 0.20);
        } else {
            return price - (price * 0.30);
        }
    }

    public static String getRandomDate() {
        Random random = new Random();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, Math.abs(random.nextInt()) % 12);
        calendar.set(Calendar.DAY_OF_MONTH, Math.abs(random.nextInt()) % 30);
        calendar.setLenient(true);
        return calendar.get(calendar.DAY_OF_MONTH) + "/" + calendar.get(calendar.MONTH) + "/" + calendar.get(calendar.YEAR);
    }
}
