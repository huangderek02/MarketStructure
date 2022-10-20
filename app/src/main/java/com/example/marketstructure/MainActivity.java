// @author Ratchanont Treevijitpaisan (u7444134)
package com.example.marketstructure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private Button joinNowButton, loginButton;
    private FirebaseAuth fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = (Button) findViewById(R.id.main_login_bt);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        joinNowButton = (Button) findViewById(R.id.main_join_bt);
        joinNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        fb = FirebaseAuth.getInstance();
        if(fb.getCurrentUser() != null){
            Toast.makeText(MainActivity.this,"Logged in", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, MarketActivity.class);
            startActivity(intent);
            finish();
        }
    }

}