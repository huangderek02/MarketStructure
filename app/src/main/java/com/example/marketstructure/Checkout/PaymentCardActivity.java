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

public class PaymentCardActivity extends AppCompatActivity {

    private static final String TAG = "PaymentCardActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_4_payment_card);

        Button b_confirm = findViewById(R.id.b_confirm_card_payment);
        Button b_cancel = findViewById(R.id.b_cancel_card_payment);

        b_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaymentCardActivity.this, ConfirmOrderActivity.class);
                startActivity(intent);
                RecyclerViewAdapter.status.getState().handle(Event.CardPaymentDetailsEntered);
                Log.e(TAG,"OrderStatus is in" + RecyclerViewAdapter.status.getState().toString() + "State");
            }
        });

        b_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaymentCardActivity.this, MarketActivity.class);
                startActivity(intent);
                RecyclerViewAdapter.status.getState().handle(Event.Cancelled);
                Log.e(TAG,"OrderStatus is in" + RecyclerViewAdapter.status.getState().toString() + "State");
            }
        });
    }
}