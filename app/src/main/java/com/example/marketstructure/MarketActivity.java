package com.example.marketstructure;

import static com.example.marketstructure.generateData.GenerateRandomListings.getRandomAdditionalDetails;
import static com.example.marketstructure.generateData.GenerateRandomListings.getRandomCondition;
import static com.example.marketstructure.generateData.GenerateRandomListings.getRandomDate;
import static com.example.marketstructure.generateData.GenerateRandomListings.getRandomListingStatus;
import static com.example.marketstructure.generateData.GenerateRandomListings.getRandomListingPrice;
import static com.example.marketstructure.generateData.GenerateRandomListings.getRandomSellerUsername;
import static com.example.marketstructure.generateData.GenerateRandomListings.getRandomTextbook;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MarketActivity extends AppCompatActivity {
    @SuppressLint("StaticFieldLeak")
    public static FirebaseFirestore db = FirebaseFirestore.getInstance();
    ListView listView;
    DatabaseReference databaseReference;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
        addListings();
        databaseReference = FirebaseDatabase.getInstance().getReference("listings");
        listView = findViewById(R.id.list_view);
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String val = Objects.requireNonNull(snapshot.getValue(Listing.class)).toString();
                arrayList.add(val);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });
        addListings();
    }

    public void addListings() {
        CollectionReference listings = db.collection("listings");
        for (int i = 0; i < 10; i++) {
            Map<String, Object> listing = new HashMap<>();
            listing.put("listingId", String.valueOf(i));
            listing.put("seller", getRandomSellerUsername());
            listing.put("textbook", getRandomTextbook());
            listing.put("condition", getRandomCondition());
            listing.put("additionalDetails", getRandomAdditionalDetails(Objects.requireNonNull(listing.get("condition"))));
            listing.put("listingPrice", getRandomListingPrice((Textbook) (Objects.requireNonNull(listing.get("textbook"))), Objects.requireNonNull(listing.get("condition")), listing.get("additionalDetails")));
            listing.put("listingLastUpdatedDate", getRandomDate());
            listing.put("listingStatus", getRandomListingStatus());
            listings.document(String.valueOf(i)).set(listing);
        }
    }
}