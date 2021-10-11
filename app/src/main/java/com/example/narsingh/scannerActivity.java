package com.example.narsingh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.narsingh.Activities.QRcodeScannerActivity;

public class scannerActivity extends AppCompatActivity {
    Button scanBtn;
    public static TextView scanTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        scanBtn = findViewById(R.id.scanBtn);
        scanTxt = findViewById(R.id.scanTxt);
        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(scannerActivity.this, QRcodeScannerActivity.class);
                startActivity(intent);
            }
        });
    }
}