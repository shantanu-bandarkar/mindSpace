package com.example.mindspace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mindspace.Contacts.Make_Call;

public class suggestions extends AppCompatActivity {
    private Button contact,breathing,music,articles,meditate;
    private TextView title;
    String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);
        contact = findViewById(R.id.contact_sugg);
        breathing = findViewById(R.id.breathing_sugg);
        music = findViewById(R.id.music_sugg);
        articles = findViewById(R.id.articles_sugg);
        meditate = findViewById(R.id.meditate_sugg);
        title = findViewById(R.id.main_title);
        Intent b= getIntent();
        value = b.getStringExtra("value");

        title.setText("Specific Suggestion");
        if(value.equals("1")){ //contact visible
            breathing.setVisibility(View.GONE);
            music.setVisibility(View.GONE);
            articles.setVisibility(View.GONE);
            meditate.setVisibility(View.GONE);
        }
        else if(value.equals("2")){  // contact, breathing visible
            music.setVisibility(View.GONE);
            articles.setVisibility(View.GONE);
            meditate.setVisibility(View.GONE);
        }
        else if(value.equals("3")){  // music visible
            breathing.setVisibility(View.GONE);
            contact.setVisibility(View.GONE);
            articles.setVisibility(View.GONE);
            meditate.setVisibility(View.GONE);
        }
        else if(value.equals("4")){  // meditate, articles visible
            breathing.setVisibility(View.GONE);
            music.setVisibility(View.GONE);
            contact.setVisibility((View.GONE));
        }
        else{
            title.setText("All Suggestion");
        }


        //onclick function
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(suggestions.this, Make_Call.class);
                startActivity(i);
            }
        });
        breathing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i = new Intent(suggestions.this, Breathing.class);
               startActivity(i);

            }
        });
        articles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(suggestions.this, AllArticles.class);
                startActivity(i);
            }
        });
        meditate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(suggestions.this, Meditation.class);
                startActivity(i);
            }
        });
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(suggestions.this, MusicPlayer.class);
                startActivity(i);
            }
        });
    }
}