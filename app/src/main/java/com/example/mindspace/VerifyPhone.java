package com.example.mindspace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class VerifyPhone extends AppCompatActivity {
    Button verify_btn;
    EditText phoneNumberEnteredByTheUser;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_phone);

        verify_btn = findViewById(R.id.btn_verify);
        phoneNumberEnteredByTheUser = findViewById(R.id.edtv_otp);
        progressBar = findViewById(R.id.prg_bar);

        String phoneNumber = getIntent().getStringExtra("phone");

       // sendVerificationCodetoUser(phoneNumber);
    }



//    private void sendVerificationCodetoUser(String phoneNumber) {
//        PhoneAuthOptions options =
//                PhoneAuthOptions.newBuilder(mAuth)
//                        .setPhoneNumber("+91"+phoneNumber)       // Phone number to verify
//                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
//                        .setActivity(this)                 // Activity (for callback binding)
//                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
//                        .build();
//        PhoneAuthProvider.verifyPhoneNumber(options);
//    }
//    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//        @Override
//        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
//
//        }
//
//        @Override
//        public void onVerificationFailed(@NonNull FirebaseException e) {
//            Toast.makeText(VerifyPhone.this,e.getMessage(),Toast.LENGTH_SHORT).show();
//        }
//    };

}