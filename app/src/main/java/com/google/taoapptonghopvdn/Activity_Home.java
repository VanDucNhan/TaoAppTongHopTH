package com.google.taoapptonghopvdn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Activity_Home extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageView bgapp = (ImageView) findViewById(R.id.bgapp);
        ImageView cloverimg = (ImageView) findViewById(R.id.cloverimg);
        LinearLayout hometxt = (LinearLayout) findViewById(R.id.hometext);
        LinearLayout splashtext = (LinearLayout) findViewById(R.id.splashtext);
        LinearLayout menus = (LinearLayout) findViewById(R.id.menus);
        LinearLayout btnprofile = (LinearLayout) findViewById(R.id.btnprofile);
        LinearLayout btnfood = (LinearLayout) findViewById(R.id.btnfood);

        Animation frombottom = (Animation) AnimationUtils.loadAnimation(this,R.anim.frombottom);

        bgapp.animate().translationY(-1300).setDuration(800).setStartDelay(300);
        cloverimg.animate().alpha(0).setDuration(800).setStartDelay(600);
        splashtext.animate().translationY(140).alpha(0).setDuration(800).setStartDelay(100);
        hometxt.startAnimation(frombottom);
        menus.startAnimation(frombottom);

        btnprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent=new Intent(Activity_Home.this, Activity_Profile.class);
                startActivity(myIntent);
            }
        });

        btnfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent=new Intent(Activity_Home.this, Activity_MonAn.class);
                startActivity(myIntent);
            }
        });
    }

}
