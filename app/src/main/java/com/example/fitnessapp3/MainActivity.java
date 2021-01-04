package com.example.fitnessapp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    TextView firstPageMoto, firstPageMotoSub, startWorkoutText, calculatorText, trackerText;
    Animation animone, animtwo, animthree, lefttoright;
    View startWorkout, startWorkoutFirstHalf, calculator, calculatorFirstHalf, tracker, trackerFirstHalf;
    AppCompatButton logoutBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animone = AnimationUtils.loadAnimation(this,R.anim.animone);
        animtwo = AnimationUtils.loadAnimation(this,R.anim.animtwo);
        animthree = AnimationUtils.loadAnimation(this,R.anim.animthree);
        lefttoright = AnimationUtils.loadAnimation(this,R.anim.lefttoright);

        firstPageMoto = (TextView)  findViewById(R.id.firstPageMoto);
        firstPageMotoSub = (TextView)  findViewById(R.id.firstPageMotoSub);
        startWorkoutText = (TextView)  findViewById(R.id.startWorkoutText);
        startWorkoutText = (TextView)  findViewById(R.id.startWorkoutText);
        calculatorText = (TextView)  findViewById(R.id.calculatorText);
        trackerText = (TextView)  findViewById(R.id.trackerText);
        startWorkout = (View) findViewById(R.id.startWorkout);
        startWorkoutFirstHalf = (View) findViewById(R.id.startWorkoutFirstHalf);
        calculator = (View) findViewById(R.id.calculator);
        calculatorFirstHalf = (View) findViewById(R.id.calculatorFirstHalf);
        tracker = (View) findViewById(R.id.tracker);
        trackerFirstHalf = (View) findViewById(R.id.trackerFirstHalf);
        logoutBtn = (AppCompatButton) findViewById(R.id.logoutBtn);

        firstPageMoto.startAnimation(animone);
        firstPageMotoSub.startAnimation(animone);
        startWorkoutText.startAnimation(animthree);
        trackerText.startAnimation(animthree);
        startWorkout.startAnimation(animtwo);
        startWorkoutFirstHalf.startAnimation(lefttoright);
        trackerFirstHalf.startAnimation(lefttoright);
        calculatorText.startAnimation(animthree);
        calculator.startAnimation(animtwo);
        tracker.startAnimation(animtwo);
        logoutBtn.startAnimation(lefttoright);
        calculatorFirstHalf.startAnimation(lefttoright);

        startWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a= new Intent(MainActivity.this, WorkoutAct.class);
                startActivity(a);
            }
        });
        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a= new Intent(MainActivity.this, CalculatorAct.class);
                startActivity(a);
            }
        });

        tracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a= new Intent(MainActivity.this,Tracker.class);
                startActivity(a);
            }
        });

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout(v);
            }
        });
    }

    public  void logout(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }
}