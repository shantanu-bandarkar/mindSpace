package com.example.mindspace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash_screen extends AppCompatActivity {

    private static int SPLASH_SCREEN = 2500;

    Animation anim;
    ImageView img_logo;
    TextView txt_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        anim = AnimationUtils.loadAnimation(this,R.anim.logo_anim);

        img_logo = findViewById(R.id.logo);
        txt_logo = findViewById(R.id.name_logo);

        img_logo.setAnimation(anim);
        txt_logo.setAnimation(anim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                View view;
                Intent intent = new Intent(Splash_screen.this, Login_page.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }
}