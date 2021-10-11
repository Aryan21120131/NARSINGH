package com.example.narsingh.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.narsingh.R;

public class ContactUs extends AppCompatActivity {

    ImageView instagram,facebook,youtube,twitter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        hook();
        instagram.setOnClickListener(view -> gotoUrl("https://www.facebook.com/BJP4India/"));
        youtube.setOnClickListener(view -> gotoUrl("https://www.youtube.com/watch?v=W_ItY2pCbXk"));
        twitter.setOnClickListener(view -> gotoUrl("https://twitter.com/imVkohli"));
        facebook.setOnClickListener(view -> gotoUrl("https://www.facebook.com/NJP4INDIA/"));

    }

    private void hook() {
        instagram=findViewById(R.id.instagramContactUs);
        youtube=findViewById(R.id.youTubeContactUs);
        twitter=findViewById(R.id.TwitterContactUs);
        facebook=findViewById(R.id.facebookContactUs);
    }

    private void gotoUrl(String s) {
        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}