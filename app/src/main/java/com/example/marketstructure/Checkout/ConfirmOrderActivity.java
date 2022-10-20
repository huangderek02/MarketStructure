package com.example.marketstructure.Checkout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.marketstructure.MarketActivity;
import com.example.marketstructure.R;
import com.example.marketstructure.RecyclerViewAdapter;
import com.example.marketstructure.StateDesignPattern.Event;

import java.text.DecimalFormat;
import java.util.Objects;

public class ConfirmOrderActivity extends AppCompatActivity {

    private static final String TAG = "ConfirmOrderActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_5_confirm_order);

        TextView orderSummaryIsbn = findViewById(R.id.tv_order_summary_isbn_display);
        TextView orderSummaryTextbookPrice = findViewById(R.id.tv_order_summary_textbook_price_display);
        TextView orderSummaryDeliveryOption = findViewById(R.id.tv_order_summary_delivery_option_selected_display);
        TextView orderSummaryRecipientName = findViewById(R.id.tv_order_summary_recipient_name_display);
        TextView orderSummaryStreetAddress = findViewById(R.id.tv_order_summary_delivery_address_display);
        TextView orderSummaryPaymentMethod = findViewById(R.id.tV_order_summary_payment_method_selected_display);
        TextView orderSummaryTotalCost = findViewById(R.id.tv_order_summary_total_cost_display);

        Button b_confirm = findViewById(R.id.b_place_order);
        Button b_cancel = findViewById(R.id.b_order_confirm_cancel);

        Intent intent = getIntent();
        String isbn = intent.getStringExtra("isbn");
        String textbookPrice = intent.getStringExtra("textbookPrice");
        String deliveryOption = intent.getStringExtra("deliveryOption");
        String recipientName = intent.getStringExtra("recipientName");
        String streetAddress = intent.getStringExtra("streetAddress");
        String paymentMethod = intent.getStringExtra("paymentMethod");

        orderSummaryIsbn.setText(isbn);
        orderSummaryTextbookPrice.setText(textbookPrice);
        orderSummaryDeliveryOption.setText(deliveryOption);
        orderSummaryRecipientName.setText(recipientName);
        orderSummaryStreetAddress.setText(streetAddress);
        orderSummaryPaymentMethod.setText(paymentMethod);
        orderSummaryTotalCost.setText(calculateTotalCost(textbookPrice,deliveryOption,paymentMethod));

        b_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Order Submitted - Returning to Listings Search", Toast.LENGTH_LONG);
                toast.show();
                Intent intent = new Intent(ConfirmOrderActivity.this, MarketActivity.class);
                startActivity(intent);
                RecyclerViewAdapter.status.getState().handle(Event.OrderConfirmed);
                Log.e(TAG, "OrderStatus is in" + RecyclerViewAdapter.status.getState().toString() + "State");
            }
        });

        b_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfirmOrderActivity.this, MarketActivity.class);
                startActivity(intent);
                RecyclerViewAdapter.status.getState().handle(Event.Cancelled);
                Log.e(TAG, "OrderStatus is in" + RecyclerViewAdapter.status.getState().toString() + "State");
            }
        });
    }

    public String calculateTotalCost(String textbookPrice, String deliveryOption, String paymentOption) {
        final DecimalFormat df = new DecimalFormat("0.00");
        double textPriceDouble = Double.parseDouble(textbookPrice);
        double deliveryPrice;
        if (Objects.equals(deliveryOption, "Express")) {
            deliveryPrice = 15;
        } else {
            deliveryPrice = 10;
        }
        double totalCostExclSurcharge = textPriceDouble + deliveryPrice;
        double totalCost;

        if (Objects.equals(paymentOption, "Card")) {
            double cardSurcharge = totalCostExclSurcharge * 0.015;
            totalCost = totalCostExclSurcharge + cardSurcharge;
        } else {
            totalCost = totalCostExclSurcharge;
        }
        return df.format(totalCost);
    }
}