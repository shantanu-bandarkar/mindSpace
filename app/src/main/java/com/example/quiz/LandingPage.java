package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LandingPage extends AppCompatActivity {
    Button takeTestBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        takeTestBtn.setBackgroundColor(Color.parseColor("R.color.happyTheme"));

        takeTestBtn = (Button) findViewById(R.id.takeTestBtn);
        takeTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTestPage();
            }
        });
    }

    protected void openTestPage() {
        Intent testPage = new Intent(this, MainActivity.class);
        startActivity(testPage);
    }
}