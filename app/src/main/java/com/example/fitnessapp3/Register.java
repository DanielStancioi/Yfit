package com.example.fitnessapp3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    EditText name, email, password, passwordConf;
    AppCompatButton registerBtn;
    TextView toLogin;
    FirebaseAuth dbAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        passwordConf = (EditText) findViewById(R.id.passwordConf);
        registerBtn = (AppCompatButton) findViewById(R.id.registerBtn);
        toLogin = (TextView) findViewById(R.id.toLogin);

        dbAuth = FirebaseAuth.getInstance();

        if(dbAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        toLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s_email = email.getText().toString();
                String s_password = password.getText().toString();
                String s_passwordConf = passwordConf.getText().toString();

                if(TextUtils.isEmpty(s_email)){
                    email.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(s_password)){
                    password.setError(" Password is required");
                    return;
                }
                if(s_password.compareTo(s_passwordConf) != 0){
                    passwordConf.setError("Not the same as initial password");
                    return;
                }

                dbAuth.createUserWithEmailAndPassword(s_email, s_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                       if(task.isSuccessful()){
                           Toast.makeText(Register.this, "Profile created", Toast.LENGTH_SHORT).show();
                           startActivity(new Intent(getApplicationContext(),MainActivity.class));
                       } else{
                           Toast.makeText(Register.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                       }
                    }
                });


            }
        });
    }
}