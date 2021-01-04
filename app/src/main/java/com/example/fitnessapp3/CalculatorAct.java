package com.example.fitnessapp3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorAct extends AppCompatActivity {
    EditText weight, height;
    TextView details;
    androidx.appcompat.widget.AppCompatButton resultBtn, resetBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);


        weight = (EditText) findViewById(R.id.weight);
        height = (EditText) findViewById(R.id.height);
        details = (TextView) findViewById(R.id.details);
        resultBtn = (androidx.appcompat.widget.AppCompatButton) findViewById(R.id.resultBtn);
        resetBtn = (androidx.appcompat.widget.AppCompatButton) findViewById(R.id.resetBtn);

        resultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strW = weight.getText().toString();
                String strH = height.getText().toString();
                if(strW.equals("")){
                    weight.setError("Please enter your weight");
                    weight.requestFocus();
                    return;
                }
                if(strH.equals("")){
                    height.setError("Please enter your height");
                    height.requestFocus();
                    return;
                }
                float w = Float.parseFloat(strW);
                float h = Float.parseFloat(strH)/100;
                float bmi = calculate(w,h);

                details.setText(interpret(bmi));
            }
        });
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weight.setText("");
                height.setText("");
                details.setText("");
            }
        });
    }

    public float calculate(float w, float h){
        return w/(h*h);
    }
    public String interpret(float bmi){
        if (bmi < 16) {
            return "Severely Underweight";
        }
        else if(bmi < 18.5){
            return "Underweight";
        }
        else if(bmi < 25){
            return "Normal Weight";
        }
        else if(bmi < 30){
            return "Overweight";
        }
        else{
            return "Obese";
        }
    }

}