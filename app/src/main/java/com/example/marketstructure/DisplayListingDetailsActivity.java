// @author Derek Huang (u7300484), Huiguang Zhang (u7366836) & Rhonda Luu (u7127350)
package com.example.marketstructure;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.marketstructure.Checkout.DeliveryOptionsMenuActivity;
import com.example.marketstructure.StateDesignPattern.Event;

import java.io.Serializable;

public class DisplayListingDetailsActivity extends AppCompatActivity implements Serializable {

    private static final String TAG = "DisplayListingDetails";;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textbook_detail_viewer);

        TextView tv_fraud_warning = findViewById(R.id.tv_fraud_warning);

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
        Button b_buy_now= findViewById(R.id.b_buy_now);

        Intent intent = getIntent();
        Listing listingFromAdapter = (Listing) intent.getExtras().getSerializable("listing");
        int textbookImageId = getResources().getIdentifier("@drawable/"+listingFromAdapter.getTextbook().getTextbookImageName(),null, getPackageName());
        Drawable resources = getResources().getDrawable(textbookImageId);
        iv_textbook_image.setImageDrawable(resources);
        tv_listing_id.setText(listingFromAdapter.getListingId());
        tv_listing_status.setText(listingFromAdapter.getListingStatus());
        tv_condition.setText(listingFromAdapter.getCondition());
        tv_listing_price.setText(listingFromAdapter.getListingPrice());
        tv_isbn.setText(listingFromAdapter.getTextbook().getIsbn());
        tv_textbook_name.setText(listingFromAdapter.getTextbook().getTitle());
        tv_authors.setText(listingFromAdapter.getTextbook().getAuthors());
        tv_edition.setText(String.valueOf(listingFromAdapter.getTextbook().getEdition()));
        tv_year_published.setText(String.valueOf(listingFromAdapter.getTextbook().getYearPublished()));
        tv_number_of_pages.setText(String.valueOf(listingFromAdapter.getTextbook().getNumberOfPages()));
        tv_topic_code.setText(listingFromAdapter.getTextbook().getTopicCode());
        tv_topic.setText(listingFromAdapter.getTextbook().getTopic());
        tv_additional_details.setText(listingFromAdapter.getAdditionalDetails());
        tv_seller.setText(listingFromAdapter.getSellerUsername());
        tv_listing_last_updated.setText(listingFromAdapter.getListingLastUpdatedDate());

        if (tv_listing_status.getText() == "Fraud Listing/Seller Identified") {
//            tv_fraud_warning.isShown();
        }

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

        b_report_listing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(DisplayListingDetailsActivity.this, ReportSellersActivity.class);
                startActivity(b);
            }
        });
        b_buy_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisplayListingDetailsActivity.this, DeliveryOptionsMenuActivity.class);
                intent.putExtra("isbn", listingFromAdapter.getTextbook().getIsbn());
                intent.putExtra("textbookPrice", listingFromAdapter.getListingPrice());
                startActivity(intent);
                RecyclerViewAdapter.status.getState().handle(Event.ListingSelectedToBuy);
                Log.e(TAG,"OrderStatus is in" + RecyclerViewAdapter.status.getState().toString() + "State");
            }
        });
    }

    @Override
    public Intent getIntent() {
        return super.getIntent();
    }
}