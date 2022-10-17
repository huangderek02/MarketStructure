package com.example.marketstructure;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText login_email, login_password;
    private ProgressBar progressBar;
    private Button login_btn, forget_password;
    private FirebaseAuth authentic_Login;
    private int backPressed = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_email = (EditText) findViewById(R.id.lg_email);
        login_password = (EditText) findViewById(R.id.lg_password);
        login_btn = (Button) findViewById(R.id.lg_loginButton);
        forget_password = (Button) findViewById(R.id.forget_pass);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        authentic_Login = FirebaseAuth.getInstance();
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = login_email.getText().toString().trim();
                String password = login_password.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    login_email.setError("Empty Email");
                    Toast.makeText(getApplicationContext(), "Please enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    login_password.setError("Empty Password");
                    Toast.makeText(getApplicationContext(),"Please enter password!",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(password.length() < 6){
                    login_password.setError("Password length is less than 6");
                    Toast.makeText(getApplicationContext(),"Password is too short, minimum size is at least 6!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                loginUser(email,password);
            }

        });


        //change password
        forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = new EditText(view.getContext());
                AlertDialog.Builder forgotPasswordBox = new AlertDialog.Builder(view.getContext());
                forgotPasswordBox.setTitle("Reset Password!");
                forgotPasswordBox.setMessage("Enter your Email to Received Reset Link.");
                forgotPasswordBox.setView(editText);

                forgotPasswordBox.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String email = editText.getText().toString();
                        authentic_Login.sendPasswordResetEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(LoginActivity.this,"Reset Link sent to email", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(LoginActivity.this,"Error on reset"+ e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

                forgotPasswordBox.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                forgotPasswordBox.create().show();
            }
        });
    }

    @Override
    public void onBackPressed(){
        backPressed++;
        if(backPressed==1){
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        super.onBackPressed();
    }

    @Override
    public void onStart(){
        super.onStart();
        authentic_Login = FirebaseAuth.getInstance();
        if(authentic_Login.getCurrentUser() != null){
            Toast.makeText(LoginActivity.this,"Logged in", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, MarketActivity.class);
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(LoginActivity.this,"Pleased Login", Toast.LENGTH_SHORT).show();
        }
    }

    private void loginUser(String email, String password){
        authentic_Login.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this,"Login Success. ", Toast.LENGTH_SHORT).show();
                            //test
                            Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                            progressBar.setVisibility(View.GONE);
                            startActivity(intent);
                            finish();
                            Toast.makeText(LoginActivity.this,"Login Success. ", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(LoginActivity.this,"Authentication failed. ", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}