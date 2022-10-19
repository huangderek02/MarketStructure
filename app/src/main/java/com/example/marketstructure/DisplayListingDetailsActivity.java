package com.example.marketstructure;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.Serializable;

public class DisplayListingDetailsActivity extends AppCompatActivity implements Serializable {

    private static final String TAG = "DisplayListingDetails";;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textbook_detail_viewer);

        ImageView iv_textbook_image = findViewById(R.id.iv_textbook_image);
        TextView tv_listing_id = findViewById(R.id.tv_listing_id_display);
        TextView tv_listing_status = findViewById(R.id.tv_listing_status_display);
        TextView tv_condition= findViewById(R.id.tv_condition_display);
        TextView tv_listing_price = findViewById(R.id.tv_listing_price_display);
        TextView tv_isbn = findViewById(R.id.tv_isbn_display);
        TextView tv_textbook_name = findViewById(R.id.tv_textbook_name_display);
        TextView tv_authors = findViewById(R.id.tv_authors_display);
        TextView tv_edition = findViewById(R.id.tv_edition_display);
        TextView tv_year_published = findViewById(R.id.tv_year_published_display);
        TextView tv_number_of_pages = findViewById(R.id.tv_number_of_pages_display);
        TextView tv_topic_code = findViewById(R.id.tv_topic_code_display);
        TextView tv_topic = findViewById(R.id.tv_topic_display);
        TextView tv_additional_details = findViewById(R.id.tv_additional_details_display);
        TextView tv_seller = findViewById(R.id.tv_seller_display);
        TextView tv_listing_last_updated = findViewById(R.id.tv_listing_last_updated_display);

        Button b_view_seller_profile = findViewById(R.id.b_view_seller_profile);
        Button b_message_seller = findViewById(R.id.b_message_seller);
        Button b_report_listing = findViewById(R.id.b_report_listing);
        Button b_make_bid = findViewById(R.id.b_buy_now);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Intent intent = getIntent();
        //String documentId = intent.getStringExtra("documentId");

        Listing listingFromAdapter = (Listing) intent.getExtras().getSerializable("listing");
        tv_listing_id.setText(listingFromAdapter.getListingId());
        tv_listing_status.setText(listingFromAdapter.getListingStatus());
        tv_condition.setText(listingFromAdapter.getCondition());
        tv_listing_price.setText(listingFromAdapter.getListingPrice());
        tv_isbn.setText(listingFromAdapter.getIsbn());
        tv_textbook_name.setText(listingFromAdapter.getTitle());
        tv_authors.setText(listingFromAdapter.getAuthors());
        tv_edition.setText(listingFromAdapter.getEdition());
        tv_year_published.setText(listingFromAdapter.getYearPublished());
        tv_number_of_pages.setText(listingFromAdapter.getNumberOfPages());
        tv_topic_code.setText(listingFromAdapter.getTopicCode());
        tv_topic.setText(listingFromAdapter.getTopic());
        tv_additional_details.setText(listingFromAdapter.getAdditionalDetails());
        tv_seller.setText(listingFromAdapter.getSellerUsername());
        tv_listing_last_updated.setText(listingFromAdapter.getListingLastUpdatedDate());


//        DocumentReference documentReference = db.collection("listings").document(documentId);
//        documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                if (task.isSuccessful()) {
//                    DocumentSnapshot documentSnapshot = task.getResult();
//                    if (documentSnapshot.exists()) {
//                        int textbookImageId = getResources().getIdentifier(documentSnapshot.getString("textbookImageName"), "drawable", getPackageName());
//                        iv_textbook_image.setImageResource(textbookImageId);
//                        tv_listing_id.setText(documentSnapshot.getString("listingId"));
//                        tv_listing_status.setText(documentSnapshot.getString("listingStatus"));
//                        tv_condition.setText(documentSnapshot.getString("condition"));
//                        tv_listing_price.setText(documentSnapshot.getString("listingPrice"));
//                        tv_isbn.setText(documentSnapshot.getString("isbn"));
//                        tv_textbook_name.setText(documentSnapshot.getString("title"));
//                        tv_authors.setText(documentSnapshot.getString("authors"));
//                        tv_edition.setText(documentSnapshot.getString("edition"));
//                        tv_year_published.setText(documentSnapshot.getString("yearPublished"));
//                        tv_number_of_pages.setText(documentSnapshot.getString("numberOfPages"));
//                        tv_topic_code.setText(documentSnapshot.getString("topicCode"));
//                        tv_topic.setText(documentSnapshot.getString("topic"));
//                        tv_additional_details.setText(documentSnapshot.getString("additionalDetails"));
//                        tv_seller.setText(documentSnapshot.getString("seller"));
//                        tv_listing_last_updated.setText(documentSnapshot.getString("listingLastUpdatedDate"));
//                        Log.d(TAG, "DocumentSnapshot data: " + documentSnapshot.getData());
//                        } else {
//                            Log.d(TAG, "No such document");
//                        }
//                    } else {
//                        Log.d(TAG, "get failed with ", task.getException());
//                    }
//                }
//        });

        b_message_seller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(DisplayListingDetailsActivity.this,ChatActivity.class);
                startActivity(b);
            }
        });

        b_view_seller_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(DisplayListingDetailsActivity.this,Sellers.class);
                startActivity(b);
            }
        });


    }

    @Override
    public Intent getIntent() {
        return super.getIntent();
    }
}