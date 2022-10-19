package com.example.marketstructure.Checkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.marketstructure.R;

public class PaymentMethodMenu extends AppCompatActivity {

    Button b_cash_payment = findViewById(R.id.b_cash_payment);
    Button b_card_payment = findViewById(R.id.b_card_payment);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_3_payment_method_menu);

        b_card_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaymentMethodMenu.this,PaymentCardActivity.class);
                startActivity(intent);
            }
        });
    }
}