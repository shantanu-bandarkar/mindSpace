package com.example.mindspace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;


public class AllArticles extends AppCompatActivity {

    TextView article1,article2,article3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_articles);
        article1 = findViewById(R.id.article1);
        article1.setMovementMethod(LinkMovementMethod.getInstance());
        article2 = findViewById(R.id.article2);
        article2.setMovementMethod(LinkMovementMethod.getInstance());
        article3 = findViewById(R.id.article3);
        article3.setMovementMethod(LinkMovementMethod.getInstance());
    }
}