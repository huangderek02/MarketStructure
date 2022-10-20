package com.example.marketstructure.Checkout;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.marketstructure.R;
import com.example.marketstructure.RecyclerViewAdapter;
import com.example.marketstructure.StateDesignPattern.Event;

public class DeliveryOptionsMenuActivity extends AppCompatActivity {

    private static final String TAG = "DeliveryOptionsMenuActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_1_delivery_options_menu);

        Button b_standard_delivery = findViewById(R.id.b_standard_delivery);
        Button b_express_delivery = findViewById(R.id.b_express_delivery);

        b_standard_delivery.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeliveryOptionsMenuActivity.this,DeliveryDetailsActivity.class);
                intent.putExtra("deliveryOption", "standard");
                startActivity(intent);
                RecyclerViewAdapter.status.getState().handle(Event.DeliveryOptionSelected);
                Log.e(TAG,"OrderStatus is in" + RecyclerViewAdapter.status.getState().toString() + "State");
            }
        });

        b_express_delivery.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeliveryOptionsMenuActivity.this,DeliveryDetailsActivity.class);
                intent.putExtra("Delivery Option", "express");
                startActivity(intent);
                RecyclerViewAdapter.status.getState().handle(Event.DeliveryOptionSelected);
                Log.e(TAG,"OrderStatus is in" + RecyclerViewAdapter.status.getState().toString() + "State");
            }
        });
    }
}