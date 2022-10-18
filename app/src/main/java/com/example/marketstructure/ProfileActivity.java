package com.example.marketstructure;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marketstructure.Model.ModelUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ProfileActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    TextView username, userEmail;
    Button logout;
    ProgressBar progressBar;
    Dialog dialog,dialogM,dialogP;
    TextInputEditText editName,editEmail;
    int backPressed = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        dialog = new Dialog(this);
        dialogM = new Dialog(this);
        dialogP = new Dialog(this);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        username = findViewById(R.id.name);
        userEmail = findViewById(R.id.email);
        progressBar = findViewById(R.id.progressBar);

        displayProfile(firebaseUser);



        Button editName = (Button) findViewById(R.id.editNameButton);
        editName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEditNameDialog();

            }
        });

        Button editEmail = (Button) findViewById(R.id.editEmailButton);
        editEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEditEmailDialog();
            }
        });

        Button changePass = (Button) findViewById(R.id.editPasswordButton);
        changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openChangePassWord();
            }
        });

        Button deleteUser = (Button) findViewById(R.id.deleteUser);
        deleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder deleteAccount = new AlertDialog.Builder(view.getContext());
                deleteAccount.setTitle("Delete User Account");
                deleteAccount.setMessage("Are you sure on deleted your account");
                deleteAccount.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String userID = firebaseUser.getUid();
                        FirebaseFirestore db = FirebaseFirestore.getInstance();
                        db.collection("userList").document(userID)
                                .delete()
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        firebaseUser.delete();
                                        Toast.makeText(ProfileActivity.this,"Account has been remove from database",Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                });
                    }
                });

                deleteAccount.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                deleteAccount.create().show();
            }
        });



        logout = (Button) findViewById(R.id.sign_outButton);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                Intent intent = new Intent(ProfileActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed(){
        backPressed++;
        if(backPressed==1){
            Intent intent = new Intent(ProfileActivity.this,MarketActivity.class);
            startActivity(intent);
            finish();
        }
        super.onBackPressed();
    }

    private void displayProfile(FirebaseUser firebaseUser){
        String userID = firebaseUser.getUid();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference docRef = db.collection("userList").document(userID);
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                ModelUser modelUser = documentSnapshot.toObject(ModelUser.class);
                if(modelUser!=null){
                    String name = documentSnapshot.getString("name");
                    String email = documentSnapshot.getString("email");

                    username.setText("Name : " + name);
                    userEmail.setText("Email : " + email);

                }
            }

        });
    }

    private void openEditNameDialog(){
        dialog.setContentView(R.layout.edit_layout_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        TextInputLayout textInputLayout = dialog.findViewById(R.id.text_input_name);
        textInputLayout.setHintEnabled(false);
        editName = dialog.findViewById(R.id.name);
        String userID = firebaseUser.getUid();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference docRef = db.collection("userList").document(userID);
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                ModelUser modelUser = documentSnapshot.toObject(ModelUser.class);
                if(modelUser!=null){
                    String name = documentSnapshot.getString("name");
                    editName.setText(name);

                }
            }

        });

        Button buttonUpdate = dialog.findViewById(R.id.ButtonUpdateProfile);
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateProfile(firebaseUser);
            }
        });

        Button buttonCancel = dialog.findViewById(R.id.cancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        displayProfile(firebaseUser);
        dialog.show();


    }

    private void updateProfile(FirebaseUser firebaseUser){
        String upName = editName.getText().toString().trim();
        if(TextUtils.isEmpty(upName)){
            editName.setError("Please enter new name");
        }else{
            String userID = firebaseUser.getUid();
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            db.collection("userList").document(userID)
                    .update("name",upName)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            UserProfileChangeRequest profileChangeRequest = new UserProfileChangeRequest.Builder()
                                    .setDisplayName(upName).build();
                            firebaseUser.updateProfile(profileChangeRequest);
                            Toast.makeText(ProfileActivity.this,"Profile has been updated",Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            restartApp();

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(ProfileActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    });

        }
    }

    private void openEditEmailDialog(){
        dialogM.setContentView(R.layout.edit_layout_dialog_2);
        dialogM.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        TextInputLayout textInputLayout = dialogM.findViewById(R.id.text_input_new_email);
        textInputLayout.setHintEnabled(false);
        editEmail = dialogM.findViewById(R.id.new_email);
        String userID = firebaseUser.getUid();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference docRef = db.collection("userList").document(userID);
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                ModelUser modelUser = documentSnapshot.toObject(ModelUser.class);
                if(modelUser!=null){
                    String email = documentSnapshot.getString("email");
                    editEmail.setText(email);

                }
            }

        });

        Button buttonUpdate = dialogM.findViewById(R.id.confirm_email_button);
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateEmail(firebaseUser);
            }
        });

        Button buttonCancel = dialogM.findViewById(R.id.cancel_email);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogM.dismiss();
            }
        });
        displayProfile(firebaseUser);
        dialogM.show();
    }

    private void updateEmail(FirebaseUser firebaseUser){
        String upEmail = editEmail.getText().toString().trim();
        if(TextUtils.isEmpty(upEmail)){
            editName.setError("Please enter new email");
        }else{
            String userID = firebaseUser.getUid();
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            db.collection("userList").document(userID)
                    .update("email",upEmail)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            firebaseUser.updateEmail(upEmail);
                            Toast.makeText(ProfileActivity.this,"Email has been updated",Toast.LENGTH_SHORT).show();
                            dialogM.dismiss();
                            restartApp();

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(ProfileActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    });

        }
    }

    private void openChangePassWord(){
        dialogP.setContentView(R.layout.edit_layout_dialog_3);
        dialogP.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        EditText inputPass = dialogP.findViewById(R.id.text_input_new_pass);
        Button setPassButton = dialogP.findViewById(R.id.confirm_password_button);
        setPassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newPass = inputPass.getText().toString().trim();
                if (TextUtils.isEmpty(newPass)) {
                    Toast.makeText(ProfileActivity.this,"Please put proper password",Toast.LENGTH_SHORT).show();
                }else{
                    firebaseUser.updatePassword(newPass);
                    Toast.makeText(ProfileActivity.this,"Password Change",Toast.LENGTH_SHORT).show();
                    dialogP.dismiss();
                    restartApp();

                }
            }
        });

        Button cancelPass = dialogP.findViewById(R.id.cancel_password);
        cancelPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogP.dismiss();
            }
        });
        displayProfile(firebaseUser);
        dialogP.show();

    }





    private void restartApp(){
        Intent intent = new Intent(getApplicationContext(),ProfileActivity.class);
        startActivity(intent);
        finish();
    }
}