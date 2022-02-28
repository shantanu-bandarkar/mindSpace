package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView questionTV,questionNumTV;
    private Button option1btn,option2btn, option3btn, option4btn;
    private ArrayList<QuizModal> quizModalArrayList;
    Random random;
    int current_score=0, questionAttempted=1, currentPos=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionTV = (TextView) findViewById(R.id.tvQuestion);
        questionNumTV = (TextView) findViewById(R.id.tvAttemptedQ);
        option1btn = (Button) findViewById(R.id.btnOpt1);
        option2btn = (Button) findViewById(R.id.btnOpt2);
        option3btn = (Button) findViewById(R.id.btnOpt3);
        option4btn = (Button) findViewById(R.id.btnOpt4);
        quizModalArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestions(quizModalArrayList);
        setDataToViews(currentPos);

        option1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase(Locale.ROOT).equals(option1btn.getText().toString().trim().toLowerCase(Locale.ROOT))){
                    current_score++;
                }
                questionAttempted++;
                currentPos+=1;
                if(currentPos<quizModalArrayList.size()){
                    setDataToViews(currentPos);
                }
            }
        });
        option2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase(Locale.ROOT).equals(option2btn.getText().toString().trim().toLowerCase(Locale.ROOT))){
                    current_score++;
                }
                questionAttempted++;
                currentPos+=1;
                if(currentPos<quizModalArrayList.size()){
                    setDataToViews(currentPos);
                }
            }
        });
        option3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase(Locale.ROOT).equals(option3btn.getText().toString().trim().toLowerCase(Locale.ROOT))){
                    current_score++;
                }
                questionAttempted++;
                currentPos+=1;
                if(currentPos<quizModalArrayList.size()){
                    setDataToViews(currentPos);
                }
            }
        });
        option4btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase(Locale.ROOT).equals(option4btn.getText().toString().trim().toLowerCase(Locale.ROOT))){
                    current_score++;
                }
                questionAttempted++;
                currentPos+=1;
                if(currentPos<quizModalArrayList.size()){
                    setDataToViews(currentPos);
                }
            }
        });

    }
    private void setDataToViews(int currentPos){
        questionNumTV.setText("Questions Attempted: "+questionAttempted+"/10");
        questionTV.setText(quizModalArrayList.get(currentPos).getQuestion());
        option1btn.setText(quizModalArrayList.get(currentPos).getOption1());
        option2btn.setText(quizModalArrayList.get(currentPos).getOption2());
        option3btn.setText(quizModalArrayList.get(currentPos).getOption3());
        option4btn.setText(quizModalArrayList.get(currentPos).getOption4());

    }
    private void getQuizQuestions(ArrayList<QuizModal> quizModalArrayList) {
        quizModalArrayList.add(new QuizModal("Can you tell us about your sleep over the last few weeks ?","I have been sleeping more than usual","I have been sleeping less than usual","I have been sleeping less than usual","I haven't noticed any changes","I haven't noticed any changes"));
        quizModalArrayList.add(new QuizModal("How has your apetite been over the last few weeks?","I had larger apetite","I had smaller apetite","I have skipped meals.","I haven't noticed","I haven't noticed"));
        quizModalArrayList.add(new QuizModal("Have you been less active than usual?","Not really","maybe a little","quite a bit","alot","alot"));
        quizModalArrayList.add(new QuizModal("I'm not interested in doing things I used to enjoy before.","Strongly disagree","Disagree","Agree","Strongly Agree","Strongly Agree"));
        quizModalArrayList.add(new QuizModal("How are you doing?","Well!","Just fine","Poor","Never felt this better","Never felt this better"));
        quizModalArrayList.add(new QuizModal("I have difficulty concentrating and focusing on tasks.","Not at all","somewhat","qiute a lot","very much","very much"));
        quizModalArrayList.add(new QuizModal("I feel restless sometimes, like I can’t stop moving.","Not at all","somewhat","qiute a lot","very much","very much"));
        quizModalArrayList.add(new QuizModal("I have trouble making even simple decisions.","Not at all","somewhat","qiute a lot","very much","very much"));
        quizModalArrayList.add(new QuizModal("Sometimes I just feel “bone tired” no matter how much sleep I get.","Not at all","somewhat","qiute a lot","very much","very much"));
        quizModalArrayList.add(new QuizModal("Some days I feel like I just can’t do anything right.","Not at all","somewhat","qiute a lot","very much","very much"));
    }
}