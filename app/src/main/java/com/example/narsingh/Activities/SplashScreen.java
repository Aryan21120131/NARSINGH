package com.example.narsingh.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.narsingh.MainActivity;
import com.example.narsingh.R;

public class SplashScreen extends AppCompatActivity {


//    VideoView splashScreenVideoHolder;
//    TextView skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Thread td = new Thread(){
            public void run(){
                try {
                    sleep(3000);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(SplashScreen.this , HomeScreenActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        td.start();
//        hook();
//
//        splashScreenVideoHolder.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.vid);
//        splashScreenVideoHolder.setOnPreparedListener(mediaPlayer -> mediaPlayer.start());
//        splashScreenVideoHolder.setOnCompletionListener(mediaPlayer -> mediaPlayer.start());
//        skip.setOnClickListener(view -> startActivity(new Intent(SplashScreen.this, HomeScreenActivity.class)));
//    }
//
//    private void hook() {
//        splashScreenVideoHolder=findViewById(R.id.splashScreenVideoHolder);
//        skip=findViewById(R.id.skip);
    }
}