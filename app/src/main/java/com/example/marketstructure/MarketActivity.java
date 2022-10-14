package com.example.marketstructure;

import static com.example.marketstructure.generateData.GenerateRandomListings.getRandomAdditionalDetails;
import static com.example.marketstructure.generateData.GenerateRandomListings.getRandomCondition;
import static com.example.marketstructure.generateData.GenerateRandomListings.getRandomDate;
import static com.example.marketstructure.generateData.GenerateRandomListings.getRandomListingStatus;
import static com.example.marketstructure.generateData.GenerateRandomListings.getRandomListingPrice;
import static com.example.marketstructure.generateData.GenerateRandomListings.getRandomSellerUsername;
import static com.example.marketstructure.generateData.GenerateRandomListings.getRandomTextbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MarketActivity extends AppCompatActivity {
    public static final String TAG = "MarketActivity";
    @SuppressLint("StaticFieldLeak")
    public static FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
        FirebaseFirestore.getInstance();
        addListings();
    }

    public void addListings() {
        for (int i = 0; i < 10; i++) {
            Map<String, Object> listing = new HashMap<>();
            listing.put("listingId", String.valueOf(i));
            listing.put("seller", getRandomSellerUsername());
            listing.put("textbook", getRandomTextbook());
            listing.put("condition", getRandomCondition());
            listing.put("additionalDetails", getRandomAdditionalDetails(Objects.requireNonNull(listing.get("condition"))));
            listing.put("listingPrice", getRandomListingPrice((Textbook) (listing.get("textbook")), listing.get("condition"), listing.get("additionalDetails")));
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
        }
    }
}