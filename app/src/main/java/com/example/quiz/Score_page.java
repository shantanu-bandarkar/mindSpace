package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class Score_page extends AppCompatActivity {
    private EditText displayscore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_page);

        Intent b= getIntent();
        displayscore = findViewById(R.id.Score);
        if(b!=null){
            displayscore.setText(String.valueOf(b.getStringExtra("score")));
        }
    }
}