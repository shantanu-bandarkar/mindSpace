package com.example.mindspace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ForgetPass extends AppCompatActivity {

    private TextInputLayout mobileNInput;
    private Button forgotPassBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        forgotPassBtn = (Button) findViewById(R.id.forget_password_next_btn_id);
        mobileNInput = (TextInputLayout) findViewById(R.id.inputMobileid);

        Log.i("forgotPass","oncreate");


        forgotPassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobile = mobileNInput.getEditText().getText().toString();
                Log.i("forgotPass","oncreate1");
                if (mobile.length() != 10){
                    Toast.makeText(getApplicationContext(),
                                    "Please check mobile number",
                                    Toast.LENGTH_LONG)
                            .show();
                    return;
                }

                String phonenumber ="+91"+mobile;
                Query checkuser= FirebaseDatabase.getInstance().getReference("users").orderByChild("phone").equalTo(phonenumber);
                Log.i("forgotPass","oncreate2");

                checkuser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            Log.i("forgotPass","oncreate3");
                            Intent intent = new Intent(ForgetPass.this,VerifyPhone.class);
                            intent.putExtra("Phone",mobile);
                            intent.putExtra("whatToDo","updateTheData");
                            startActivity(intent);
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}