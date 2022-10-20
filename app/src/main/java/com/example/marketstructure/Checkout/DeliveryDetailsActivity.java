package com.example.marketstructure.Checkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.marketstructure.MarketActivity;
import com.example.marketstructure.R;
import com.example.marketstructure.RecyclerViewAdapter;
import com.example.marketstructure.StateDesignPattern.Event;

public class DeliveryDetailsActivity extends AppCompatActivity {

    private static final String TAG = "DeliveryDetailsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_2_delivery_details);

        Button b_proceed_to_payment = findViewById(R.id.b_proceed_to_payment);
        Button b_cancel = findViewById(R.id.b_cancel_deliver_details);

        Intent intent = getIntent();
        String deliveryOption = intent.getStringExtra("deliveryOption");

        b_proceed_to_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeliveryDetailsActivity.this, PaymentMethodMenu.class);
                intent.putExtra("deliveryOption",deliveryOption);
                startActivity(intent);
                RecyclerViewAdapter.status.getState().handle(Event.DeliveryDetailsEntered);
                Log.e(TAG,"OrderStatus is in" + RecyclerViewAdapter.status.getState().toString() + "State");
            }
        });

        b_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeliveryDetailsActivity.this, MarketActivity.class);
                startActivity(intent);
                RecyclerViewAdapter.status.getState().handle(Event.Cancelled);
                Log.e(TAG,"OrderStatus is in" + RecyclerViewAdapter.status.getState().toString() + "State");
            }
        });
    }
}