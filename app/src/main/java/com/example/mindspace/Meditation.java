package com.example.mindspace;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Meditation extends AppCompatActivity {
    MediaPlayer mp;
    Button meditateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation);
        final boolean[] isPlaying = {false};

        mp = MediaPlayer.create(this, R.raw.med);
        meditateBtn = findViewById(R.id.meditateBtn);

        meditateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPlaying[0] == false) {
                    mp.start();
                    isPlaying[0] = true;
                }

                else {
                    mp.pause();
                    isPlaying[0] = false;
                }
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        if (this.isFinishing()){
            mp.stop();
        }
    }
}
