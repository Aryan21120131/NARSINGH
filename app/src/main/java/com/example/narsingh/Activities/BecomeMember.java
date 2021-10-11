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

public class BecomeMember extends AppCompatActivity {

    EditText name,email,phoneNumber,AadharNumber,PinCodeNumber;
    Button BecomeAMemberButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_become_member);
        hook();
        BecomeAMemberButton.setOnClickListener(view -> Toast.makeText(BecomeMember.this, name.getText().toString()+
                email.getText().toString()+
                phoneNumber.getText().toString()+
                AadharNumber.getText().toString()+
                PinCodeNumber.getText().toString(), Toast.LENGTH_SHORT).show());
    }

    private void hook() {
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        BecomeAMemberButton=findViewById(R.id.BecomeAMemberButton);
        phoneNumber=findViewById(R.id.phoneNumber);
        AadharNumber=findViewById(R.id.AadharNumber);
        PinCodeNumber=findViewById(R.id.PinCodeNumber);
    }
}