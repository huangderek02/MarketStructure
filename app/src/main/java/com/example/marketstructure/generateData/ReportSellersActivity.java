package com.example.marketstructure.generateData;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.marketstructure.R;

public class ReportSellersActivity extends AppCompatActivity {
    EditText editText = findViewById(R.id.editTextTextPersonName);
    Button button = findViewById(R.id.button2);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_sellers);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "we will deal with this issues asap", Toast.LENGTH_SHORT).show();
            }
        });

    }
}