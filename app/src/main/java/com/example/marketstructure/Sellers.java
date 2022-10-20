package com.example.marketstructure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Sellers extends AppCompatActivity {

    float rating = 0;
    ArrayList<Float> Ratings = new ArrayList<>();
    Button avgRtngBtn;
    RatingBar ratingBar;
    Button flagSellerButton;
    boolean flagged = false;
    TextView status;
    TextView av_r;
    TextView seller_name_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller);
        av_r = findViewById(R.id.average_rating);
        av_r.setText("no rating now");
        avgRtngBtn = findViewById(R.id.view_avg_rtng);
        ratingBar = findViewById(R.id.ratingBar);
        status = findViewById(R.id.status);
        status.setText("unflagged");
        flagSellerButton = findViewById(R.id.flag_seler);


        //This code is for when the rating bar on the UI is used. The rating given is
        //by default rounded down to the nearest whole number. The maximum rating given
        // is 5 and the minimum rating given is 0. This code also adds the ratings to the
        // ArrayList of ratings.
        // The message displayed varies case by case of the rating. This also updates the
        // average rating text in the Seller Activity.
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
                av_r.setText(String.valueOf(sum(Ratings) / Ratings.size()));
                Toast.makeText(Sellers.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        //This code allows the user to see the average rating of the seller. The average
        // rating is calculated by dividing the sum of the arraylist by the length of the
        // arraylist.
        avgRtngBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Sellers.this,String.valueOf((sum(Ratings) / Ratings.size())) ,
                        Toast.LENGTH_SHORT).show();
                //writeToFile("file.txt",String.valueOf((sum(Ratings) / Ratings.size())));
            }
        });

        //This code is for when the Flag Seller button is clicked. This updates the status
        //of the seller from Unflagged to Flagged. This is so the administrator can look
        //into the seller if there is a feature to log in as an administrator (which there
        // isn't).
        flagSellerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Sellers.this,"This seller has been flagged." +
                                "We'll look into it." ,
                        Toast.LENGTH_SHORT).show();
                flagged = true;
                if(flagged){
                    status.setText("Flagged");
                }
            }
        });

    }

    /**
     * Gets the sum of an arraylist.
     * Used to help find the average rating of a seller.
     */
    static float sum(ArrayList<Float> arr)
    {
        float sum = 0; // initialize sum
        int i;

        // Iterate through all elements and add them to sum
        for (i = 0; i < arr.size(); i++)
            sum += arr.get(i);

        return sum;
    }

    public void writeToFile(String fileName, String content){
        File path = getApplicationContext().getFilesDir();
        try {
            FileOutputStream writer = new FileOutputStream(new File(path, fileName));
            writer.write(content.getBytes());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}