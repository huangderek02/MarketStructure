/**
 * This class is used for the activity_checkout_2_delivery_details activity screen.
 * It records the user's delivery details and also changes the state of OrderStatus.
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

public class DeliveryDetailsActivity extends AppCompatActivity {

    private EditText et_recipient_name, et_email_address, et_phone_number, et_street_address;

    private static final String TAG = "DeliveryDetailsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_2_delivery_details);

        et_recipient_name = (EditText) findViewById(R.id.et_recipient_name);
        et_email_address = (EditText) findViewById(R.id.et_email_address);
        et_phone_number = (EditText) findViewById(R.id.et_phone_number);
        et_street_address = (EditText) findViewById(R.id.et_street_address);

        Button b_proceed_to_payment = findViewById(R.id.b_proceed_to_payment);
        Button b_cancel = findViewById(R.id.b_cancel_deliver_details);

        /** Bring intent strings from previous class, DeliveryOptionsMenuActivity and ui screen
         * "Delivery Options Menu" (activity_checkout_1_delivery_options_menu.xml)
         */
        Intent intent = getIntent();
        String isbn = intent.getStringExtra("isbn");
        String textbookPrice = intent.getStringExtra("textbookPrice");
        String deliveryOption = intent.getStringExtra("deliveryOption");

        /**
         * This method controls the actions of the "Proceed To Payment" button.
         * It checks if all EditText ui elements have been filled in before navigating to
         * "Payment Method Menu" (activity_checkout_3_payment_method_menu.xml).
         */
        b_proceed_to_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String recipient_name = et_recipient_name.getText().toString().trim();
                String email_address = et_email_address.getText().toString().trim();
                String phone_number = et_phone_number.getText().toString().trim();
                String street_address = et_street_address.getText().toString().trim();

                /** Checks if the EditText ui elements in the activity screen has all been filled in
                 * otherwise display toast to prompt user to fill in the missed field.
                 */
                if(TextUtils.isEmpty(recipient_name)){
                    Toast.makeText(getApplicationContext(), "Please enter recipient name", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(email_address)){
                    Toast.makeText(getApplicationContext(),"Please enter email address",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(phone_number)){
                    Toast.makeText(getApplicationContext(),"Please enter phone number",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(street_address)){
                    Toast.makeText(getApplicationContext(),"Please enter street address",Toast.LENGTH_SHORT).show();
                } else {
                    // Navigate to "Payment Method Menu" (activity_checkout_3_payment_method_menu.xml)
                    Intent intent = new Intent(DeliveryDetailsActivity.this, PaymentMethodMenu.class);
                    // save intent strings to use for confirm summary activity
                    intent.putExtra("isbn", isbn);
                    intent.putExtra("textbookPrice", textbookPrice);
                    intent.putExtra("deliveryOption", deliveryOption);
                    intent.putExtra("recipientName", et_recipient_name.getText().toString());
                    intent.putExtra("streetAddress", et_street_address.getText().toString());
                    startActivity(intent);
                    // Change State of orderStatus to WaitingToSelectPaymentMethod from WaitingToEnterDeliveryDetails
                    RecyclerViewAdapter.status.getState().handle(Event.DeliveryDetailsEntered);
                    Log.e(TAG, "OrderStatus is in" + RecyclerViewAdapter.status.getState().toString() + "State");
                }
            }
        });

        /**
         * This method controls the actions of the "Cancel" button.
         * Navigates back to "Market Activity" ui screen (activity_market.xml).
         */
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