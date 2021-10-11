package com.example.narsingh.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.example.narsingh.R;

public class BecomeVolunteer extends AppCompatActivity {

    EditText nameBecomeVolunteer,emailBecomeVolunteer;
    Button BecomeVolunteer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_become_volunteer);
        hook();
        BecomeVolunteer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BecomeVolunteer.this, nameBecomeVolunteer.getText().toString()+
                        emailBecomeVolunteer.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void hook() {
        nameBecomeVolunteer=findViewById(R.id.nameBecomeVolunteer);
        emailBecomeVolunteer=findViewById(R.id.emailBecomeVolunteer);
        BecomeVolunteer=findViewById(R.id.BecomeVolunteer);
    }
}