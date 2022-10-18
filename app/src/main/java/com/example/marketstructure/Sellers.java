package com.example.marketstructure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Sellers extends AppCompatActivity {

    float rating = 0;
    ArrayList<Float> Ratings = new ArrayList<>();
    Button avgRtngBtn;
    RatingBar ratingBar;
    Button flagSellerButton;
    boolean flagged = false;
    TextView status = findViewById(R.id.status);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller);

        avgRtngBtn = findViewById(R.id.view_avg_rtng);
        ratingBar = findViewById(R.id.ratingBar);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                int rating = (int) v;
                String msg = null;
                Ratings.add((float) rating);

                switch (rating){
                    case 1:
                        msg = "Sorry to hear that!";
                        break;
                    case 2:
                        msg = "I always welcome feedback";
                        break;
                    case 3:
                        msg = "Good enough!";
                        break;
                    case 4:
                        msg = "Excellent thanks!";
                        break;
                    case 5:
                        msg = "You're the greatest!";
                        break;
                }

                Toast.makeText(Sellers.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        avgRtngBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Sellers.this,String.valueOf((sum(Ratings) / Ratings.size())) ,
                        Toast.LENGTH_SHORT).show();
            }
        });

        flagSellerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Sellers.this,"This seller has been flagged." +
                                "We'll look into it." ,
                        Toast.LENGTH_SHORT).show();
                flagged = true;
            }
        });

        if(flagged ==true){
            status.setText("Flagged");
        }
    }

    static float sum(ArrayList<Float> arr)
    {
        float sum = 0; // initialize sum
        int i;

        // Iterate through all elements and add them to sum
        for (i = 0; i < arr.size(); i++)
            sum += arr.get(i);

        return sum;
    }


}