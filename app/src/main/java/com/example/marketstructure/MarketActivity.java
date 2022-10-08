package com.example.marketstructure;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MarketActivity extends AppCompatActivity {
    // add Cloud Firestore instance to access database
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public static final String TAG = "MarketActivity";
    // add sample listings data
    public void addListings() {
        addListing();
    }

    public void addListing() {
        int i = 0;
        while (i < 2000) {
            Map<String, Object> listing = new HashMap<>();
            listing.put("seller", GenerateTextbookDataListings.getRandomSellerUsername());
            listing.put("textbook", GenerateTextbookDataListings.getRandomTextbook());
            listing.put("price", GenerateTextbookDataListings.getRandomPrice(GenerateTextbookDataListings.getRandomTextbook().price - GenerateTextbookDataListings.getRandomTextbook().price * 0.2, GenerateTextbookDataListings.getRandomTextbook().price));
            listing.put("condition", GenerateTextbookDataListings.getRandomCondition());
            listing.put("additionalDetails", GenerateTextbookDataListings.getRandomAdditionalDetails());
            listing.put("listingLastUpdatedDate", GenerateTextbookDataListings.getRandomDate());
            listing.put("listingStatus", GenerateTextbookDataListings.getRandomListingStatus());
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

    private RecyclerView recyclerView;
    private ArrayList<RecyclerData> recyclerDataArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
    }
}