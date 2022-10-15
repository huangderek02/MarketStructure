package com.example.marketstructure;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    private EditText inputEmail, inputName, inputPassword,  inputConPass;
    private Button register_button, login_button;
    private ProgressBar progressBar;
    private FirebaseAuth authenticator;
    private int backPressed = 0;
    private String uid;
    private static final String tag = "In register act";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        authenticator = FirebaseAuth.getInstance();

        inputEmail = (EditText) findViewById(R.id.email);
        inputName = (EditText) findViewById(R.id.username);
        inputPassword = (EditText) findViewById(R.id.password);
        inputConPass = (EditText) findViewById(R.id.con_password);
        register_button = (Button) findViewById(R.id.sign_up_button);
        login_button = (Button) findViewById(R.id.sign_in_button);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputEmail.getText().toString().trim();
                String name = inputName.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();
                String cPassword = inputConPass.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Please enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(getApplicationContext(), "Please enter username!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Please enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(cPassword)) {
                    Toast.makeText(getApplicationContext(), "Please confirmed password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password is too short, minimum size is at least 6!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (cPassword.matches(password)) {
                    Toast.makeText(getApplicationContext(), "Passwords do not match!", Toast.LENGTH_SHORT).show();
                    return;
                }

                createUser(email,name,password);
            }
        });

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed(){
        backPressed++;
        if(backPressed==1){
            Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        super.onBackPressed();
    }

    private void createUser(String email, String name, String password){
        progressBar.setVisibility(View.VISIBLE);
        authenticator.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser user = authenticator.getCurrentUser();
                    uid = user.getUid();
                    String email = user.getEmail();

                    HashMap<String, Object> userList = new HashMap<>();
                    userList.put("uid",uid);
                    userList.put("email", email);
                    userList.put("name", name);
                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    db.collection("userList")
                            .add(userList)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Log.d(tag, "DocumentSnapshot added with ID: " + documentReference.getId());
                                    Toast.makeText(RegisterActivity.this,"create user with email complete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(RegisterActivity.this, MarketActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.w(tag,"Error adding document", e);
                                }
                            });
                }else{
                    Toast.makeText(RegisterActivity.this, "Authentication failed." + task.getException(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}