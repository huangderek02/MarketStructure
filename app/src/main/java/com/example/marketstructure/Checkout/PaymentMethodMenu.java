/**
 * This class is used for the activity_checkout_3_payment_method_menu activity screen.
 * It shows the different payment options.
 * @author Rhonda Luu (u7127350)
 */

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

public class PaymentMethodMenu extends AppCompatActivity {

    private static final String TAG = "PaymentMethodMenu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_3_payment_method_menu);

        Button b_cash_payment = findViewById(R.id.b_cash_payment);
        Button b_card_payment = findViewById(R.id.b_card_payment);
        Button b_cancel = findViewById(R.id.b_cancel_payment);

        Intent intent = getIntent();
        String isbn = intent.getStringExtra("isbn");
        String textbookPrice = intent.getStringExtra("textbookPrice");
        String deliveryOption = intent.getStringExtra("deliveryOption");
        String recipientName = intent.getStringExtra("recipientName");
        String streetAddress = intent.getStringExtra("streetAddress");

        b_cash_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaymentMethodMenu.this,ConfirmOrderActivity.class);
                intent.putExtra("deliveryOption", deliveryOption);
                intent.putExtra("recipientName", recipientName);
                intent.putExtra("streetAddress", recipientName);
                intent.putExtra("paymentMethod", "Cash");
                startActivity(intent);
                RecyclerViewAdapter.status.getState().handle(Event.CashPaymentMethodSelected);
                Log.e(TAG,"OrderStatus is in" + RecyclerViewAdapter.status.getState().toString() + "State");
            }
        });

        b_card_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaymentMethodMenu.this,PaymentCardActivity.class);
                intent.putExtra("isbn", isbn);
                intent.putExtra("textbookPrice", textbookPrice);
                intent.putExtra("deliveryOption", deliveryOption);
                intent.putExtra("recipientName", recipientName);
                intent.putExtra("streetAddress", streetAddress);
                intent.putExtra("paymentMethod", "Card");
                startActivity(intent);
                RecyclerViewAdapter.status.getState().handle(Event.CardPaymentMethodSelected);
                Log.e(TAG,"OrderStatus is in" + RecyclerViewAdapter.status.getState().toString() + "State");
            }
        });
        b_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaymentMethodMenu.this, MarketActivity.class);
                startActivity(intent);
                RecyclerViewAdapter.status.getState().handle(Event.Cancelled);
                Log.e(TAG,"OrderStatus is in" + RecyclerViewAdapter.status.getState().toString() + "State");
            }
        });
    }
}