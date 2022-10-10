package com.example.marketstructure.generateData;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class GenerateDataInstances extends GenerateTextbookDataListings {
    // add Cloud Firestore instance to access database
    private static FirebaseFirestore db = FirebaseFirestore.getInstance();

    public static final String TAG = "MarketActivity";
    // add sample listings data
    public static void addListings() {
        int i = 0;
        while (i < 2500) {
            Map<String, Object> listing = new HashMap<>();
            listing.put("listingId", i+1);
            listing.put("seller", getRandomSellerUsername());
            listing.put("textbook", getRandomTextbook());
            listing.put("price", getRandomPrice(getRandomTextbook().getPrice() - getRandomTextbook().getPrice() * 0.2, getRandomTextbook().getPrice()));
            listing.put("condition", getRandomCondition());
            listing.put("additionalDetails", getRandomAdditionalDetails());
            listing.put("listingLastUpdatedDate", getRandomDate());
            listing.put("listingStatus", getRandomListingStatus());
            db.collection("listings")
                    .add(listing)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG, "Error adding document", e);
                        }
                    });
            i++;
        }
    }
}
