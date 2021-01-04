package com.example.fitnessapp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WorkoutAct extends AppCompatActivity {
    TextView workouts, workoutsSub, introduction, introductionSub;
    TextView chestTitle, chestTitleSub, backTitle, backTitleSub, legsTitle, legsTitleSub, shouldersTitle, shouldersTitleSub, bicepsTitle, bicepsTitleSub;
    View divPage;
    Animation animone, animtwo, animfour, lefttoright1, animfive;
    LinearLayout workoutPage, workoutPage1, workoutPage2, workoutPage3, workoutPage4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        animone = AnimationUtils.loadAnimation(this, R.anim.animone);
        animtwo = AnimationUtils.loadAnimation(this, R.anim.animtwo);
        animfour = AnimationUtils.loadAnimation(this, R.anim.animfour);
        lefttoright1 = AnimationUtils.loadAnimation(this, R.anim.lefttoright1);
        animfive = AnimationUtils.loadAnimation(this, R.anim.animfive);

        workouts = (TextView) findViewById(R.id.workouts);
        workoutsSub = (TextView) findViewById(R.id.workoutsSub);
        introduction = (TextView) findViewById(R.id.introduction);
        introductionSub = (TextView) findViewById(R.id.introductionSub);


        chestTitle = (TextView) findViewById(R.id.chestTitle);
        chestTitleSub = (TextView) findViewById(R.id.chestTitleSub);
        backTitle = (TextView) findViewById(R.id.backTitle);
        backTitleSub = (TextView) findViewById(R.id.backTitleSub);
        legsTitle = (TextView) findViewById(R.id.legsTitle);
        legsTitleSub = (TextView) findViewById(R.id.legsTitleSub);
        shouldersTitle = (TextView) findViewById(R.id.shouldersTitle);
        shouldersTitleSub = (TextView) findViewById(R.id.shouldersTitleSub);
        bicepsTitle = (TextView) findViewById(R.id.bicepsTitle);
        bicepsTitleSub = (TextView) findViewById(R.id.bicepsTitleSub);

        divPage = (View) findViewById(R.id.divPage);

        workoutPage = (LinearLayout) findViewById(R.id.workoutPage);
        workoutPage1 = (LinearLayout) findViewById(R.id.workoutPage1);
        workoutPage2 = (LinearLayout) findViewById(R.id.workoutPage2);
        workoutPage3 = (LinearLayout) findViewById(R.id.workoutPage3);
        workoutPage4 = (LinearLayout) findViewById(R.id.workoutPage4);


        workouts.startAnimation(animfive);
        workoutsSub.startAnimation(animfive);
        divPage.startAnimation(animfive);
        introduction.startAnimation(animfive);
        introductionSub.startAnimation(animfive);
        workoutPage.startAnimation(animfour);
        workoutPage1.startAnimation(animfour);
        workoutPage2.startAnimation(animfour);
        workoutPage3.startAnimation(animfour);
        workoutPage4.startAnimation(animfour);

        workoutPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b= new Intent(WorkoutAct.this, ChestAct.class);
                startActivity(b);
            }
        });
        workoutPage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c= new Intent(WorkoutAct.this, BackAct.class);
                startActivity(c);
            }
        });
        workoutPage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d= new Intent(WorkoutAct.this, LegsAct.class);
                startActivity(d);
            }
        });
        workoutPage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e= new Intent(WorkoutAct.this, ShouldersAct.class);
                startActivity(e);
            }
        });
        workoutPage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e= new Intent(WorkoutAct.this, BicepsAct.class);
                startActivity(e);
            }
        });
    }
}