package com.example.mindspace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.ref.Reference;

public class SignUp extends AppCompatActivity {
    TextInputLayout regName,regUsername, regPassword, regEmail, regPhone;
    Button signUP_btn,haveAcc_btn;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        haveAcc_btn = findViewById(R.id.btn_haveAcc);
        regName = findViewById(R.id.txtv_name);
        regUsername = findViewById(R.id.txtv_uname);
        regPassword = findViewById(R.id.txtv_pass);
        regEmail = findViewById(R.id.txtv_email);
        regPhone = findViewById(R.id.txtv_phone);
        signUP_btn = findViewById(R.id.btn_signUp);

        haveAcc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this,Login_page.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private Boolean validateName(){
        String val = regName.getEditText().getText().toString();
        if(val.isEmpty()){
            regName.setError("Field cannot be Empty");
            return false;
        }
        else{
            regName.setError(null);
            regName.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateUsername(){
        String val = regUsername.getEditText().getText().toString();
        String noWhiteSpace="\\A\\w{4,20}\\z";
        if(val.isEmpty()){
            regUsername.setError("Field cannot be Empty");
            return false;
        }
        else if(!val.matches(noWhiteSpace)){
            regUsername.setError("Whitespace not allowed.");
            return false;
        }
        else{
            regUsername.setError(null);
            regUsername.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateEmail(){
        String val = regEmail.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(val.isEmpty()){
            regEmail.setError("Field cannot be Empty");
            return false;
        }
        else if(!val.matches(emailPattern)){
            regEmail.setError("Invalid Email Address");
            return false;
        }
        else{
            regEmail.setError(null);
            regEmail.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePhone(){
        String val = regPhone.getEditText().getText().toString();
        if(val.isEmpty()){
            regPhone.setError("Field cannot be Empty");
            return false;
        }
        else{
            regPhone.setError(null);
            regPhone.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePassword(){
        String val = regPassword.getEditText().getText().toString();
        String PassVal = "^(?=.*[a-zA-Z])(?=.*[@#$%^&*])(?=\\S+$).{4,}$";
        if(val.isEmpty()){
            regPassword.setError("Field cannot be Empty");
            return false;
        }
        else if(!val.matches(PassVal)) {
            regPassword.setError("Weak Password!");
            return false;
        }
        else{
            regPassword.setError(null);
            regPassword.setErrorEnabled(false);
            return true;
        }
    }


    public void registerUser(View view){
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("users");

        if(!validateName() | !validateUsername() | !validateEmail() | !validatePhone() | !validatePassword()){
            return;
        }

        String name = regName.getEditText().getText().toString();
        String username = regUsername.getEditText().getText().toString();
        String email = regEmail.getEditText().getText().toString();
        String phone = regPhone.getEditText().getText().toString();
        String password = regPassword.getEditText().getText().toString();

//        Intent intent = new Intent(SignUp.this,VerifyPhone.class);
//        intent.putExtra("Phone number",phone);
//        startActivity(intent);
         UserHelperClass helperClass = new UserHelperClass(name,username,email,phone,password);
        reference.child(username).setValue(helperClass);

        Toast.makeText(this,"Your Account has been created!",Toast.LENGTH_SHORT).show();

        Intent i = new Intent(SignUp.this,Login_page.class);
        startActivity(i);
        finish();
    }
}