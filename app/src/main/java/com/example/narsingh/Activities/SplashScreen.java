package com.example.narsingh.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.narsingh.MainActivity;
import com.example.narsingh.R;

public class SplashScreen extends AppCompatActivity {


    VideoView splashScreenVideoHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        hook();

        splashScreenVideoHolder.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.website);
        splashScreenVideoHolder.setOnPreparedListener(mediaPlayer -> mediaPlayer.start());
        splashScreenVideoHolder.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
            }
        });
    }

    private void hook() {
        splashScreenVideoHolder=findViewById(R.id.splashScreenVideoHolder);
    }
}