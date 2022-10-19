package com.example.marketstructure;

import static com.example.marketstructure.GenerateData.GenerateRandomListings.getRandomAdditionalDetails;
import static com.example.marketstructure.GenerateData.GenerateRandomListings.getRandomCondition;
import static com.example.marketstructure.GenerateData.GenerateRandomListings.getRandomDate;
import static com.example.marketstructure.GenerateData.GenerateRandomListings.getRandomListingStatus;
import static com.example.marketstructure.GenerateData.GenerateRandomListings.getRandomListingPrice;
import static com.example.marketstructure.GenerateData.GenerateRandomListings.getRandomSellerUsername;
import static com.example.marketstructure.GenerateData.GenerateRandomListings.getRandomTextbook;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import tokenizer_and_parser.TextbookSearcher;

public class MarketActivity extends AppCompatActivity implements RecyclerViewClickListener, Serializable
{

    private RecyclerView recyclerView;
    private ArrayList<Listing> listingsArrayList = new ArrayList<Listing>();
    private ArrayList<Listing> listingsArrayList2 = new ArrayList<Listing>();
    ProgressDialog progressDialog;
    private Listing listing = new Listing("","",null,"","","","","");


    //private Listing listing = new Listing("","",0,"","","",0,0,"","","","","","","","","");

    Button visitProfile;
    EditText searchText;
    String searchString;
    TextbookSearcher textbookSearcher;
    ArrayList<tokenizer_and_parser.Textbook> results;

    @SuppressLint("StaticFieldLeak")
    public static FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        listingsArrayList = addListings();
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading Listings...");
        //progressDialog.show();
        recyclerView = findViewById(R.id.recycle_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(listingsArrayList, this);

        visitProfile = findViewById(R.id.button_to_profile);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        searchText = findViewById(R.id.search_text);
        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                searchString = s.toString();
                textbookSearcher = new TextbookSearcher();
                textbookSearcher.parseSearch(searchString);
                textbookSearcher.sortAlphabeticalAscending();
                results = textbookSearcher.getResults();
            }
        });




        //EventChangeListener();





//        recyclerView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent b = new Intent(MarketActivity.this,DisplayListingDetailsActivity.class);
//                startActivity(b);
//            }
//        });



        visitProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(MarketActivity.this, ProfileActivity.class);
                startActivity(b);
            }
        });











        /*
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

         */

    }

    private void EventChangeListener() {
        db.collection("listings")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (error != null) {
                            Log.e("Firestore error",error.getMessage());
                            return;
                        }
                        assert value != null;
                        for (DocumentChange documentChange : value.getDocumentChanges()) {
                           // if (documentChange.getType() == DocumentChange.Type.ADDED) {

                                listingsArrayList.add(documentChange.getDocument().toObject(Listing.class));
                            }
                        }
                 //   }
                });
        /*
        db.collection("listings").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()) {
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot documentSnapshot : list) {
                                Listing listing = documentSnapshot.toObject(Listing.class);
                                listingsArrayList.add(listing);
                            }
                        }
                    }
                });

         */

    }


    public ArrayList<Listing> addListings() {
        CollectionReference listings = db.collection("listings");
        ArrayList<Listing> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Map<String, Object> listing = new HashMap<>();
            listing.put("listingId", String.valueOf(i));
            listing.put("sellerUsername", getRandomSellerUsername());
            listing.put("textbook", getRandomTextbook());
            listing.put("condition", getRandomCondition());
            listing.put("additionalDetails", getRandomAdditionalDetails(Objects.requireNonNull(listing.get("condition"))));
            listing.put("listingPrice", getRandomListingPrice((Textbook) (Objects.requireNonNull(listing.get("textbook"))), Objects.requireNonNull(listing.get("condition")), listing.get("additionalDetails")));
            listing.put("listingLastUpdatedDate", getRandomDate());
            listing.put("listingStatus", getRandomListingStatus());
            listings.document(String.valueOf(i)).set(listing);
            Listing listing1 = new Listing((String) listing.get("listingId"),(String) listing.get("sellerUsername"), (Textbook) listing.get("textbook"),
                    (String) listing.get("listingPrice"),(String) listing.get("condition"),(String) listing.get("additionalDetails"),(String) listing.get("listingStatus"),
                    (String) listing.get("listingLastUpdatedDate"));



            arrayList.add(listing1);
        }
        return arrayList;
    }



    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}