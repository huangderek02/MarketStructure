package com.example.marketstructure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.marketstructure.generateData.GenerateDataInstances;

public class MarketActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
        GenerateDataInstances.addListings();
    }
}