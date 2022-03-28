package com.example.mindspace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;
public class login_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView username=(TextView)findViewById(R.id.username);
        TextView password=(TextView)findViewById(R.id.password);
        Button login=(Button) findViewById(R.id.login);
        //admin and admin
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("admin")&& password.getText().toString().equals("admin"))
                {
                    //correct
                    Toast.makeText(login_page.this,"login is successfully",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(login_page.this,"login is failed!!!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}