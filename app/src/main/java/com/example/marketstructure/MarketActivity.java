package com.example.marketstructure;

import static com.example.marketstructure.GenerateData.GenerateRandomListings.getRandomAdditionalDetails;
import static com.example.marketstructure.GenerateData.GenerateRandomListings.getRandomCondition;
import static com.example.marketstructure.GenerateData.GenerateRandomListings.getRandomDate;
import static com.example.marketstructure.GenerateData.GenerateRandomListings.getRandomListingStatus;
import static com.example.marketstructure.GenerateData.GenerateRandomListings.getRandomListingPrice;
import static com.example.marketstructure.GenerateData.GenerateRandomListings.getRandomSellerUsername;
import static com.example.marketstructure.GenerateData.GenerateRandomListings.getRandomTextbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import tokenizer_and_parser.TextbookSearcher;

public class MarketActivity extends AppCompatActivity implements RecyclerViewClickListener, Serializable {
    private RecyclerView recyclerView;
    private ArrayList<Listing> listingsArrayList = new ArrayList<Listing>();
    public static ArrayList<Listing> listingsArrayList_search = new ArrayList<Listing>();

    ProgressDialog progressDialog;

    Button visitProfile;
    EditText searchText;
    String searchString;
    TextbookSearcher textbookSearcher;
    ArrayList<Listing> results;

    @SuppressLint("StaticFieldLeak")
    public static FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        listingsArrayList = addListings();
        listingsArrayList_search = new ArrayList<>(listingsArrayList);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading Listings...");
        recyclerView = findViewById(R.id.recycle_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(listingsArrayList, this);

        visitProfile = findViewById(R.id.button_to_profile);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        searchText = findViewById(R.id.search_text);
        searchText.addTextChangedListener(new TextWatcher() {
            //No results are expected to change before the text is changed
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            //No results are expected to change when editing the text
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            //After the text is changed,
            @Override
            public void afterTextChanged(Editable s) {
                searchString = s.toString();
                textbookSearcher = new TextbookSearcher();
                textbookSearcher.parseSearch(searchString);
                textbookSearcher.sortAlphabeticalAscending();
                results = textbookSearcher.getResults();
            }
        });

        //When you click on the visit profile button, it takes you to the
        //page where the seller can upload their details or logout.
        visitProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(MarketActivity.this, ProfileActivity.class);
                startActivity(b);
            }
        });
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
            Listing listing1 = new Listing((String) listing.get("listingId"), (String) listing.get("sellerUsername"), (Textbook) listing.get("textbook"),
                    (String) listing.get("listingPrice"), (String) listing.get("condition"), (String) listing.get("additionalDetails"), (String) listing.get("listingStatus"),
                    (String) listing.get("listingLastUpdatedDate"));
            arrayList.add(listing1);
        }
        return arrayList;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }


    /**
     * TODO: Delete this comment
     * <p>
     * Untested code from u7117043 (Gordon) to get search bar and recycle view working.
     */

    //Used to check sorting pattern
    private Integer sortingPattern = 0;
    private TextbookSearcher myTBSearcher = new TextbookSearcher();

    /**
     * onClick for searchButton:
     * Gets the string in the searh_text, finds and updates textbooks in Recycleview
     */
    public void updateTextbooks(View v) {
        String query = searchText.getText().toString();
        myTBSearcher.parseSearch(query);

        sortResults();
        updateRecycle();

    }

    /**
     * onClick for sort_button:
     * Increment sortingPattern and then sort results. Update the recycle view with new sorting pattern
     */
    public void sortRecycle(View v) {
        if (sortingPattern >= 9) sortingPattern = 0;
        else sortingPattern++;

        sortResults();
        updateRecycle();
    }

    /**
     * Update recycle viewer with new listings from a user search or sort
     */
    public void updateRecycle() {

        recyclerView = findViewById(R.id.recycle_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(myTBSearcher.getResults(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    /**
     * Sort results of a search depending on sorting pattern integer.
     * Sorting pattern integer is changed by the sort button.
     */
    public void sortResults() {
        switch (sortingPattern) {
            case 1:
                myTBSearcher.sortAlphabeticalDescending();
                break;
            case 2:
                myTBSearcher.sortCostAscending();
                break;
            case 3:
                myTBSearcher.sortCostDescending();
                break;
            case 4:
                myTBSearcher.sortTopicAscending();
                break;
            case 5:
                myTBSearcher.sortTopicDescending();
                break;
            case 6:
                myTBSearcher.sortEditionAscending();
                break;
            case 7:
                myTBSearcher.sortEditionDescending();
                break;
            case 8:
                myTBSearcher.sortPageAscending();
                break;
            case 9:
                myTBSearcher.sortPageDescending();
                break;
            default:
                myTBSearcher.sortAlphabeticalAscending();
        }
    }
}


