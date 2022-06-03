package com.example.mindspace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Score_page extends AppCompatActivity {
    private TextView displayscore;
    private int score;
    private Button specific_sug , all_sug ;
    private TextView level,quotes,descrip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_page);
        specific_sug = findViewById(R.id.specific_sug);
        all_sug = findViewById(R.id.all_sug);
        level = findViewById(R.id.level);
        quotes =findViewById(R.id.quotes);
        descrip = findViewById(R.id.description);

        Intent b= getIntent();
        displayscore = findViewById(R.id.Score);
        if(b!=null){
            displayscore.setText(String.valueOf(b.getStringExtra("score")));
        }
        score = Integer.parseInt(String.valueOf(b.getStringExtra("score")));


        if(score>=0 && score<=10){
            level.setText("Severe levels of depression");
            quotes.setText("\"Self pity gets you nowhere.\n Self love does.\" ");
            descrip.setText("Looks like you need to consult a mental health professional. There is hope, even when your brain tells you there isn't.\n\n There are far, far better things ahead.");
        }
        else if(score>=11 && score<=20){
            level.setText("Moderate symptoms of depression");
            quotes.setText("\" Breathe in deeply and let your life unfold.\" ");
            descrip.setText("Hang in there! Go with your pace, try finding happiness in little things and believe that the best is on its way.");
        }
        else if(score>=21 && score<=30){
            level.setText("Low symptoms of depression");
            quotes.setText("\" You’re not a bad person for the ways you tried to kill your sadness. \" ");
            descrip.setText("There is nothing to worry about. We understand what you are going through.\n\nJust give yourself some time and the world will appear to be a happy place.");
        }
        else if(score>=31 && score<=40){
            level.setText("Just a fleeting thought");
            quotes.setText("\"Your thought is only an opinion. Just stop letting them control you.\" ");
            descrip.setText("Great going! \nPeople who score like your experience few to no signs that are typically seen in depression. This is great news. You might sometimes feel sad or low, but these feelings might be transient.\n\nOverall these concerns don't appear to be significantly get in the way of your routine or life.");

        }


        // click function
        specific_sug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Score_page.this,suggestions.class);
                if(score>=0 && score<=10){
                    i.putExtra("value","1");
                }
                else if(score>=11 && score<=20){
                    i.putExtra("value","2");
                }
                else if(score>=21 && score<=30){
                    i.putExtra("value","3");
                }
                else if(score>=31 && score<=40){
                    i.putExtra("value","4");
                }
                startActivity(i);
            }
        });

        all_sug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Score_page.this,suggestions.class);
                i.putExtra("value",String.valueOf(5));
                startActivity(i);
            }
        });
    }
}