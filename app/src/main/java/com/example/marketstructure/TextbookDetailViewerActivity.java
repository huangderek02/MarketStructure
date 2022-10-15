package com.example.marketstructure;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TextbookDetailViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textbook_detail_viewer);
        ImageView textBookImage = findViewById(R.id.iv_textbook_image);
        TextView listid = findViewById(R.id.tv_listing_id_title);
        TextView condition = findViewById(R.id.tv_condition_title);
        TextView isbn = findViewById(R.id.tv_isbn_title);
        TextView title = findViewById(R.id.tv_textbook_name_title);
        TextView author = findViewById(R.id.tv_authors_title);
        TextView edition = findViewById(R.id.tv_edition_title);
        TextView addition_details = findViewById(R.id.tv_additional_details_title);
        TextView seller = findViewById(R.id.tv_seller_title);
        TextView price = findViewById(R.id.tv_price_title);
        TextView topic_code = findViewById(R.id.tv_topic_code_display);
        TextView year_publish = findViewById(R.id.tv_year_published_title);
        Button message_seller = (Button) findViewById(R.id.button_message_seller);
        message_seller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(TextbookDetailViewerActivity.this,ChatActivity.class);
                startActivity(b);
            }
        });
































    }
}