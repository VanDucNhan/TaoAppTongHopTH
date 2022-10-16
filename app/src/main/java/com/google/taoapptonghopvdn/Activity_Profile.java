package com.google.taoapptonghopvdn;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Activity_Profile extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageView profileback = (ImageView) findViewById(R.id.profileback);
        TextView textviewlogout = (TextView) findViewById(R.id.textViewlogout);

        profileback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent=new Intent(Activity_Profile.this, Activity_Home.class);
                startActivity(myIntent);
            }
        });
        textviewlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent=new Intent(Activity_Profile.this, MainActivity.class);
                startActivity(myIntent);
            }
        });
    }
}
