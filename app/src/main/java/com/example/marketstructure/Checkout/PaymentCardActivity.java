/**
 * This class is used for the activity_checkout_4_payment_card activity screen.
 * It records the user's card details and also changes the state of OrderStatus.
 * @author Rhonda Luu (u7127350)
 */

package com.example.marketstructure.Checkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.marketstructure.MarketActivity;
import com.example.marketstructure.R;
import com.example.marketstructure.RecyclerViewAdapter;
import com.example.marketstructure.StateDesignPattern.Event;

public class PaymentCardActivity extends AppCompatActivity {

    private EditText et_card_payment_card_number, et_card_payment_expiry_month, et_card_payment_expiry_year, et_card_payment_cvv;

    private static final String TAG = "PaymentCardActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_4_payment_card);

        et_card_payment_card_number = findViewById(R.id.et_card_payment_card_number);
        et_card_payment_expiry_month = findViewById(R.id.et_card_payment_expiry_month);
        et_card_payment_expiry_year = findViewById(R.id.et_card_payment_expiry_year);
        et_card_payment_cvv = findViewById(R.id.et_card_payment_cvv);

        Button b_confirm = findViewById(R.id.b_confirm_card_payment);
        Button b_cancel = findViewById(R.id.b_cancel_card_payment);

        Intent intent = getIntent();
        String isbn = intent.getStringExtra("isbn");
        String textbookPrice = intent.getStringExtra("textbookPrice");
        String deliveryOption = intent.getStringExtra("deliveryOption");
        String recipientName = intent.getStringExtra("recipientName");
        String streetAddress = intent.getStringExtra("streetAddress");
        String paymentMethod = intent.getStringExtra("paymentMethod");

        b_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cardNumber = et_card_payment_card_number.getText().toString();
                String cardExpiryMonth = et_card_payment_expiry_month.getText().toString();
                String cardExpiryYear = et_card_payment_expiry_year.getText().toString();
                String cardCvv = et_card_payment_cvv.getText().toString();


                if(TextUtils.isEmpty(cardNumber)){
                    Toast.makeText(getApplicationContext(), "Please enter card number", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(cardExpiryMonth)){
                    Toast.makeText(getApplicationContext(),"Please enter month of card expiry date",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(cardExpiryYear)){
                    Toast.makeText(getApplicationContext(),"Please enter year of card expiry date",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(cardCvv)){
                    Toast.makeText(getApplicationContext(),"Please enter CVV of card",Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(PaymentCardActivity.this, ConfirmOrderActivity.class);
                    intent.putExtra("isbn", isbn);
                    intent.putExtra("textbookPrice", textbookPrice);
                    intent.putExtra("deliveryOption", deliveryOption);
                    intent.putExtra("recipientName", recipientName);
                    intent.putExtra("streetAddress", streetAddress);
                    intent.putExtra("paymentMethod", paymentMethod);
                    startActivity(intent);
                    RecyclerViewAdapter.status.getState().handle(Event.CardPaymentDetailsEntered);
                    Log.e(TAG, "OrderStatus is in" + RecyclerViewAdapter.status.getState().toString() + "State");
                }
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