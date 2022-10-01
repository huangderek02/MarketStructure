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
        addListing1();
        addListing2();
        addListing3();
    }

    public void addListing1() {
        Map<String, Object> listing = new HashMap<>();
        listing.put("seller", "JohnSmith");
        listing.put("isbn", "9781488620683");
        listing.put("title", "Organisational Behaviour");
        listing.put("edition", 9);
        listing.put("authors", "Stephen Robbins, Timothy A. Judge, Marissa Edwards, Peter Sandiford and Martin Fitzgerald");
        listing.put("yearPublished", 2019);
        listing.put("numberOfPages", 496);
        listing.put("topicCode", "MGMT");
        listing.put("topic", "Management");
        listing.put("price", 100.95);
        listing.put("condition", "Used");
        listing.put("additionalDetails", "This textbook has been used for about 6 months and is in good condition");
        listing.put("listingLastUpdatedDate", "19/09/2022");
        listing.put("listingStatus", "Active");
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

    public void addListing2() {
        Map<String, Object> listing = new HashMap<>();
        listing.put("seller", "JaneBrown");
        listing.put("isbn", "9781137468574");
        listing.put("title", "Organisational Behaviour");
        listing.put("edition", 2);
        listing.put("authors", "Muayyad Jabri");
        listing.put("yearPublished", 2017);
        listing.put("numberOfPages", 318);
        listing.put("topicCode", "MGMT");
        listing.put("topic", "Management");
        listing.put("price", 80);
        listing.put("condition", "New");
        listing.put("additionalDetails", "");
        listing.put("listingLastUpdatedDate", "20/09/2022");
        listing.put("listingStatus", "Active");
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

    public void addListing3() {
        Map<String, Object> listing = new HashMap<>();
        listing.put("seller", "BillJones");
        listing.put("isbn", "9781430262503");
        listing.put("title", "Beginning Haskell: A Project-Based Approach");
        listing.put("edition", 1);
        listing.put("authors", "Alejandro Serrano Mena");
        listing.put("yearPublished", 2014);
        listing.put("numberOfPages", 409);
        listing.put("topicCode", "COMP");
        listing.put("topic", "Computing");
        listing.put("price", 35);
        listing.put("condition", "Used");
        listing.put("additionalDetails", "This textbook has a clear contact cover");
        listing.put("listingLastUpdatedDate", "21/09/2022");
        listing.put("listingStatus", "Active");
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

    private RecyclerView recyclerView;
    private ArrayList<RecyclerData> recyclerDataArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
    }
}