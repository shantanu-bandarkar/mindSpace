package com.example.mindspace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login_page extends AppCompatActivity {
    TextInputLayout username,password;
    Button newUser_btn,login_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login_page);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        newUser_btn = findViewById(R.id.newuser);
        login_btn = findViewById(R.id.login);

        newUser_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_page.this,SignUp.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private Boolean validateUsername(){
        String val = username.getEditText().getText().toString();
        if(val.isEmpty()){
            username.setError("Field cannot be Empty");
            return false;
        }
        else{
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePassword(){
        String val = password.getEditText().getText().toString();

        if(val.isEmpty()){
            password.setError("Field cannot be Empty");
            return false;
        }
        else{
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }

    public void loginUser(View view){
        if(!validateUsername() | !validatePassword()){
            return;
        }
        else{
            isUser();
        }
    }

    private void isUser() {
        String userEnteredUsername = username.getEditText().getText().toString().trim();
        String userEnteredPass = password.getEditText().getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUser = reference.orderByChild("username").equalTo(userEnteredUsername);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    username.setError(null);
                    username.setErrorEnabled(false);

                    String passFromDB = snapshot.child(userEnteredUsername).child("password").getValue(String.class);

                    if(passFromDB.equals(userEnteredPass)){
                        username.setError(null);
                        username.setErrorEnabled(false);
                        Toast.makeText(getApplicationContext(),"Login Successfull",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Login_page.this,LandingPage.class);
                        startActivity(intent);
                    }
                    else{
                        password.setError("Wrong Password");
                        password.requestFocus();
                    }
                }
                else{
                    username.setError("No such user exists.");
                    username.requestFocus();
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


}