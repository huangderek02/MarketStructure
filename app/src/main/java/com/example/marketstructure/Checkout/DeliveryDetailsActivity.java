package com.example.marketstructure.Checkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        EditText et_recipient_name = findViewById(R.id.et_recipient_name);
        EditText et_email_address = findViewById(R.id.et_email_address);
        EditText et_phone_number = findViewById(R.id.et_phone_number);
        EditText et_street_address = findViewById(R.id.et_street_address);

        Button b_proceed_to_payment = findViewById(R.id.b_proceed_to_payment);
        Button b_cancel = findViewById(R.id.b_cancel_deliver_details);

        Intent intent = getIntent();
        String isbn = intent.getStringExtra("isbn");
        String textbookPrice = intent.getStringExtra("textbookPrice");
        String deliveryOption = intent.getStringExtra("deliveryOption");

        String recipient_name = et_recipient_name.getText().toString();
        String email_address = et_email_address.getText().toString();
        String phone_number = et_phone_number.getText().toString();
        String street_address = et_street_address.getText().toString();

        b_proceed_to_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                if (recipient_name.isEmpty() || email_address.isEmpty() || phone_number.isEmpty()
                        || street_address.isEmpty()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Error: Please ensure that all fields have been filled out ", Toast.LENGTH_LONG);
                    toast.show();
                } else {

                 */
                    Intent intent = new Intent(DeliveryDetailsActivity.this, PaymentMethodMenu.class);
                    intent.putExtra("isbn", isbn);
                    intent.putExtra("textbookPrice", textbookPrice);
                    intent.putExtra("deliveryOption", deliveryOption);
                    intent.putExtra("recipientName", et_recipient_name.getText().toString());
                    intent.putExtra("streetAddress", et_street_address.getText().toString());
                    startActivity(intent);
                    RecyclerViewAdapter.status.getState().handle(Event.DeliveryDetailsEntered);
                    Log.e(TAG, "OrderStatus is in" + RecyclerViewAdapter.status.getState().toString() + "State");
                }
//            }//
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