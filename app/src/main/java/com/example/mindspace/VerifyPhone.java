package com.example.mindspace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.concurrent.TimeUnit;

public class VerifyPhone extends AppCompatActivity {
    Button verify_btn;
    EditText otp;
    ProgressBar progressBar;
    private FirebaseAuth mAuth;
    String phone;
    String name,username,email,phoneNumber,password;
    String verficationCodeBySystem;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_phone);

        verify_btn = findViewById(R.id.btn_verify);
        otp = findViewById(R.id.edtv_otp);
        progressBar = findViewById(R.id.prg_bar);

         username = getIntent().getStringExtra("Username");
         name = getIntent().getStringExtra("Name");
         email = getIntent().getStringExtra("Email");
         password = getIntent().getStringExtra("Password");
         phoneNumber = getIntent().getStringExtra("Phone");

        mAuth = FirebaseAuth.getInstance();
        sendVerificationCodetoUser(phoneNumber);
    }

    private void sendVerificationCodetoUser(String phoneNumber) {
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+91"+phoneNumber)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
        Toast.makeText(VerifyPhone.this,"Sending OTP",Toast.LENGTH_SHORT).show();

    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
           final String code = phoneAuthCredential.getSmsCode();
            if(code!=null){
                otp.setText(code);
                progressBar.setVisibility(View.VISIBLE);
                verifyCode(code);
            }
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            Toast.makeText(VerifyPhone.this, "Verification Failed!", Toast.LENGTH_SHORT).show();
            Toast.makeText(VerifyPhone.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        public void onCodeSent(@NonNull String s,
                               @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s,forceResendingToken);
            verficationCodeBySystem = s;
        }
    };
    public void setOTP(View view) {
        if (TextUtils.isEmpty(otp.getText().toString())) {
            Toast.makeText(this, "Wrong OTP", Toast.LENGTH_SHORT).show();
        }
        else
            verifyCode(otp.getText().toString());
    }

    private void verifyCode(String codeByUser){
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verficationCodeBySystem,codeByUser);
        signInUser(credential);
    }

    private void signInUser(PhoneAuthCredential credential){
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(VerifyPhone.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    storedataofnewuser();
                    Toast.makeText(VerifyPhone.this,"User Created!",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(VerifyPhone.this,Login_page.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(i);
                    finish();
                }
                else{
                    Toast.makeText(VerifyPhone.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private void storedataofnewuser() {
        phone = "+91" +phoneNumber;
        FirebaseDatabase rootnode =FirebaseDatabase.getInstance();
        DatabaseReference reference = rootnode.getReference("users");
        UserHelperClass helperClass = new UserHelperClass(name,username,email,phone,password);
        reference.child(username).setValue(helperClass);

    }


}
