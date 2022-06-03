package com.example.mindspace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mindspace.Contacts.Add_contact;

public class LandingPage extends AppCompatActivity {
    Button takeTestBtn,all_sugg;
    TextView contacts,articles,breathe,meditate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        takeTestBtn = findViewById(R.id.takeTestBtn);
        contacts =  findViewById(R.id.contact);
        articles = findViewById(R.id.read);
        breathe = findViewById(R.id.breathe);
        all_sugg = findViewById(R.id.more_suggestions);
        meditate = findViewById(R.id.meditate);

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
        articles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LandingPage.this, AllArticles.class);
                startActivity(i);
            }
        });
        breathe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LandingPage.this, Breathing.class);
                startActivity(i);
            }
        });
        meditate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LandingPage.this, Meditation.class);
                startActivity(i);
            }
        });

        all_sugg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LandingPage.this,suggestions.class);
                i.putExtra("value",String.valueOf(5));
                startActivity(i);
            }
        });

    }
}