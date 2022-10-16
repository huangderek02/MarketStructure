package com.example.marketstructure.generateData;

import com.example.marketstructure.Textbook;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class GenerateRandomListings {
    public static List<Textbook> listings;
    public GenerateRandomListings() {
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

    public static String getRandomAdditionalDetails(Object condition) {
        String randomAdditionalDetails;
        if (condition.equals("New")) {
            int index = (int) (Math.random() * ListingTextbookData.additionalDetailsNew.length);
            randomAdditionalDetails = ListingTextbookData.additionalDetailsNew[index];
            return randomAdditionalDetails;
        } else if (condition.equals("Used - Good")) {
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
    public static String getRandomListingPrice(Textbook textbook, Object condition, Object additionalDetails) {
        final DecimalFormat df = new DecimalFormat("0.00");
        double originalPrice = Double.parseDouble(textbook.getOriginalPrice());
        double maxPrice = originalPrice - (originalPrice * 0.05);
        double minPrice = originalPrice - (originalPrice * 0.10);
        double randomListingPrice = Math.random() * (maxPrice - minPrice) + minPrice;

        if (condition.equals("New")
                && (additionalDetails.equals("Textbook is still in original packaging")
                || additionalDetails.equals("Textbook includes ebook code"))) {
            return df.format(randomListingPrice);
        } else if (condition.equals("New")
                && (additionalDetails.equals("Textbook ebook code has been used")
                || additionalDetails.equals("N/A"))) {
            return df.format(randomListingPrice - (randomListingPrice * 0.05));
        } else if (condition.equals("Used - Good")
                && (additionalDetails.equals("Textbook has clear contact cover")
                || additionalDetails.equals("Textbook ebook code has been used")
                || additionalDetails.equals("Textbook is in good condition, used for 6 months")
                || additionalDetails.equals("N/A")
                || additionalDetails.equals("Textbook is in good condition, used for 1 year"))) {
            return df.format(randomListingPrice - (randomListingPrice * 0.10));
        } else {
            return df.format(randomListingPrice - (randomListingPrice * 0.15));
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
