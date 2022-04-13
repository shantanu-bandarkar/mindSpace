package com.example.mindspace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mindspace.Contacts.Add_contact;

public class LandingPage extends AppCompatActivity {
    Button takeTestBtn;
    TextView contacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        takeTestBtn = findViewById(R.id.takeTestBtn);
        contacts =  findViewById(R.id.contact);

        takeTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent testPage = new Intent(LandingPage.this, MainActivity.class);
                startActivity(testPage);;
            }
        });

        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LandingPage.this, Add_contact.class);
                startActivity(i);
            }
        });
    }
}