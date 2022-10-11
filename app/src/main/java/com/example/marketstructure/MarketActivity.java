package com.example.marketstructure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.marketstructure.generateData.GenerateDataInstances;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class MarketActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        FirebaseApp.initializeApp(getBaseContext());
        GenerateDataInstances.addListings();
    }

}