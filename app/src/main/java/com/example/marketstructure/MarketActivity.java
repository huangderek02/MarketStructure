package com.example.marketstructure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.marketstructure.generateData.GenerateDataInstances;
import com.google.firebase.firestore.FirebaseFirestore;

public class MarketActivity extends AppCompatActivity {
    private static FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
        db = FirebaseFirestore.getInstance();
        GenerateDataInstances.addListings();
    }

}