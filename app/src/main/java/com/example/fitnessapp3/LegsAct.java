package com.example.fitnessapp3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LegsAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView title, titleSub, description;
        TextView Ex1Title, Ex2Title, Ex3Title, Ex4Title, Ex1TitleSub, Ex2TitleSub, Ex3TitleSub, Ex4TitleSub;
        View divPage;
        Animation animone, animtwo, animfour, lefttoright1, animfive;
        LinearLayout Ex1, Ex2, Ex3, Ex4, StartPage;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legs);
        animone = AnimationUtils.loadAnimation(this, R.anim.animone);
        animtwo = AnimationUtils.loadAnimation(this, R.anim.animtwo);
        animfour = AnimationUtils.loadAnimation(this, R.anim.animfour);
        lefttoright1 = AnimationUtils.loadAnimation(this, R.anim.lefttoright1);
        animfive = AnimationUtils.loadAnimation(this, R.anim.animfive);

        title = (TextView) findViewById(R.id.Title);
        titleSub = (TextView) findViewById(R.id.TitleSub);
        description = (TextView) findViewById(R.id.description);

        Ex1Title = (TextView) findViewById(R.id.Ex1Title);
        Ex1TitleSub = (TextView) findViewById(R.id.Ex1TitleSub);
        Ex2Title = (TextView) findViewById(R.id.Ex2Title);
        Ex2TitleSub = (TextView) findViewById(R.id.Ex2TitleSub);
        Ex3Title = (TextView) findViewById(R.id.Ex3Title);
        Ex3TitleSub = (TextView) findViewById(R.id.Ex3TitleSub);
        Ex3Title = (TextView) findViewById(R.id.Ex3Title);
        Ex3TitleSub = (TextView) findViewById(R.id.Ex3TitleSub);
        Ex4Title = (TextView) findViewById(R.id.Ex4Title);
        Ex4TitleSub = (TextView) findViewById(R.id.Ex4TitleSub);


        divPage = (View) findViewById(R.id.divPage);


        StartPage = (LinearLayout) findViewById(R.id.StartPage);
        Ex1 = (LinearLayout) findViewById(R.id.Ex1);
        Ex2 = (LinearLayout) findViewById(R.id.Ex2);
        Ex3 = (LinearLayout) findViewById(R.id.Ex3);
        Ex4 = (LinearLayout) findViewById(R.id.Ex4);

        StartPage.startAnimation(animfive);

        divPage.startAnimation(animfive);
        description.startAnimation(animfive);
        Ex1.startAnimation(animfour);
        Ex2.startAnimation(animfour);
        Ex3.startAnimation(animfour);
        Ex4.startAnimation(animfour);
    }
}