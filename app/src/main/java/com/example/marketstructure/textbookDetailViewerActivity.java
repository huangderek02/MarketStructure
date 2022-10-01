package com.example.marketstructure;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class textbookDetailViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textbookdetailviewer);
        ImageView textBookImage = findViewById(R.id.imageView);
        TextView listid = findViewById(R.id.textView_listing_id);
        TextView condition = findViewById(R.id.textView_condition);
        TextView isbn = findViewById(R.id.textView_isbn);
        TextView title = findViewById(R.id.textView_title);
        TextView author = findViewById(R.id.textView_author);
        TextView edition = findViewById(R.id.textView_edition);
        TextView addition_details = findViewById(R.id.textView_additional_details);
        TextView seller = findViewById(R.id.textView_seller);
        TextView price = findViewById(R.id.textView_price);
        TextView topic_code = findViewById(R.id.textView_topic_code);
        TextView year_publish = findViewById(R.id.textView_year_published);
        Button message_seller = (Button) findViewById(R.id.messageSellerButton);
        message_seller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(textbookDetailViewerActivity.this,ChatActivity.class);
                startActivity(b);
            }
        });
































    }
}