package com.example.mindspace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Score_page extends AppCompatActivity {
    private TextView displayscore;
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