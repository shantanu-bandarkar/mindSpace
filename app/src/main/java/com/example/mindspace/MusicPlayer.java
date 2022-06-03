package com.example.mindspace;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

public class MusicPlayer extends AppCompatActivity {

    //TextView song1, song2;
    MaterialCardView card1,card2;
    MediaPlayer mp1, mp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        card1 = findViewById(R.id.music_card1);
        card2 = findViewById(R.id.music_card2);

        mp1 = MediaPlayer.create(this, R.raw.feel);
        mp2 = MediaPlayer.create(this, R.raw.med);

        final boolean[] isPlaying1 = {false};
        final boolean[] isPlaying2 = {false};

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPlaying2[0]) {
                    mp2.pause();
                }
                mp1.start();
                isPlaying1[0] = true;

            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPlaying2[0]) {
                    mp2.pause();
                }
                mp2.start();
                isPlaying2[0] = true;
            }
        });

    }
    @Override
    protected void onPause() {
        super.onPause();
        if (this.isFinishing()){
            mp1.stop();
            mp2.stop();
        }
    }

}