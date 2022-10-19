package com.example.marketstructure.Checkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.marketstructure.R;

public class DeliveryOptionsMenuActivity extends AppCompatActivity {

    Button b_standard_delivery = findViewById(R.id.b_standard_delivery);
    Button b_express_delivery = findViewById(R.id.b_express_delivery);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_1_delivery_options_menu);

        b_standard_delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeliveryOptionsMenuActivity.this,DeliveryDetailsActivity.class);
                intent.putExtra("deliveryOption", "standard");
                startActivity(intent);
            }
        });

        b_express_delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeliveryOptionsMenuActivity.this,DeliveryDetailsActivity.class);
                intent.putExtra("Delivery Option", "express");
                startActivity(intent);
            }
        });
    }
}