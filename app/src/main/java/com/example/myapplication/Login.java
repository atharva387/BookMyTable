package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity
{
    public Button button;
    EditText username,inputemail,password1,Mobile;

    // String emailPattern = "^[A-Z0-9+_.-]+@[A-Z0-9.-]+$";
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    @SuppressLint("ServiceCast")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inputemail=findViewById(R.id.inputemail);
        password1=findViewById(R.id.password1);
        MaterialButton loginbtn=(MaterialButton) findViewById(R.id.loginbtn);
        MaterialButton signup=(MaterialButton) findViewById(R.id.signup);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();

        loginbtn.setOnClickListener (new View.OnClickListener()

        {
            @Override
            public void onClick(View view)
            {
                loginbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        performLogin();

                    }
                });
            }
        });
        signup.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login.this,signup.class);
                startActivity(intent);
            }
        }));


    }

    private void performLogin() {
        String email= inputemail.getText().toString();
        String password= password1.getText().toString();
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Login.this, "Login Successful .Welcome to Book My Table", Toast.LENGTH_SHORT).show();
                    sendUseToNextActivity();
                }
                else {
                    Toast.makeText(Login.this, "User Does Not Exist"+task.getException(), Toast.LENGTH_SHORT).show();
                }

                }

        });
    }
    private void sendUseToNextActivity() {
        Intent intent=new Intent(Login.this,homepage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}