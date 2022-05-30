package com.example.fitnessapp3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Tracker extends AppCompatActivity {
    EditText yValue, textYear;
    AppCompatButton insertBtn;
    FirebaseAuth dbAuth;
    FirebaseDatabase db;
    DatabaseReference ref;
    GraphView graphView;
    LineGraphSeries series;
    String userID;

    SimpleDateFormat sdf = new SimpleDateFormat("dd:MM");
    SimpleDateFormat sdf1 = new SimpleDateFormat("YYYY");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);

        yValue = (EditText) findViewById(R.id.yValue);
        textYear = (EditText) findViewById(R.id.textYear);

        insertBtn = (AppCompatButton) findViewById(R.id.insertBtn);
        graphView = (GraphView) findViewById(R.id.graphView);
        series = new LineGraphSeries();
        graphView.addSeries(series);

        db = FirebaseDatabase.getInstance();
        dbAuth = FirebaseAuth.getInstance();
        userID = dbAuth.getCurrentUser().getUid();

        ref = db.getReference(userID);
        series.setColor(Color.YELLOW);
        series.setDrawDataPoints(true);
        series.setThickness(10);
        series.setDrawBackground(true);
        series.setBackgroundColor(Color.argb(60, 255, 255, 0));
        graphView.getViewport().setXAxisBoundsManual(true);
        graphView.getViewport().setMinX(3);
        graphView.getViewport().setMaxX(1000);
        graphView.getViewport().setScrollable(true);
        graphView.getViewport().setScrollableY(true);
        graphView.getViewport().setScalable(true);
        graphView.getViewport().setScalableY(true);



        setListeners();




        graphView.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if(isValueX){
                    return sdf.format(new Date((long) value));
                }else {
                    return super.formatLabel(value, isValueX);
                }

            }
        });

    }

    private void setListeners() {
        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = ref.push().getKey();

                long x = new Date().getTime();
                int y = Integer.parseInt(yValue.getText().toString());

                textYear.setText(sdf1.format(new Date((long) x)));

                PointValue pointValue = new PointValue(x,y);

                ref.child(id).setValue(pointValue).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Tracker.this, "Successfully  inserted", Toast.LENGTH_SHORT).show();

                        }else{
                            Toast.makeText(Tracker.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataPoint[] dp = new  DataPoint[(int) snapshot.getChildrenCount()];
                int index = 0;

                for (DataSnapshot myDataSnapshot : snapshot.getChildren()){
                    PointValue pointValue = myDataSnapshot.getValue(PointValue.class);
                    dp[index] = new DataPoint(pointValue.getxValue(), pointValue.getyValue());
                    index++;
                }

                series.resetData(dp);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}