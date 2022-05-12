package com.example.mindspace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ResetPassword extends AppCompatActivity {
    String phone,newPass, confPass;
    private TextInputLayout newPassTextView,confPassTextView;
    Button nextBtn;
    FirebaseDatabase rootnode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        phone = getIntent().getStringExtra("phone");
        nextBtn = (Button) findViewById(R.id.set_new_password_btn_id);
        newPassTextView = (TextInputLayout) findViewById(R.id.new_password_id);
        confPassTextView = (TextInputLayout) findViewById(R.id.confirm_password_id);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newPass = newPassTextView.getEditText().getText().toString();
                confPass = confPassTextView.getEditText().getText().toString();

                if (newPass.equals(confPass)){
                    rootnode = FirebaseDatabase.getInstance();
                    reference = rootnode.getReference("users");
                    reference.child(phone).child("password").setValue(newPass);
                   // String username = reference.child(phone).child("username").get().toString();

                    Toast.makeText(ResetPassword.this, "GG ", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(ResetPassword.this,LandingPage.class);
                   // intent.putExtra("username",username);
                    startActivity(intent);
                    finish();

                }
            }
        });

    }
}