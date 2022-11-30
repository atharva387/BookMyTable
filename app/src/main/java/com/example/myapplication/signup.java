package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signup extends AppCompatActivity {

    EditText username,inputemail,password1,Mobile,confirmpassword;

   // String emailPattern = "^[A-Z0-9+_.-]+@[A-Z0-9.-]+$";
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
      username=findViewById(R.id.username);
        inputemail=findViewById(R.id.inputemail);
        password1=findViewById(R.id.password1);

        Mobile=findViewById(R.id.Mobile);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();


        MaterialButton signupbtn=(MaterialButton) findViewById(R.id.signupbtn);
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PerformAuth();

            }
        });
    }

    private void PerformAuth() {
        String email= inputemail.getText().toString();
        String password= password1.getText().toString();
        //if (email.matches(emailPattern)){
           // inputemail.setError("Enter the correct Email");
       // }else if (password.isEmpty()||password.length()<6) {
        //inputemail.setError("email cannot be empty");
      //  }
       // else if (!password.equals(confirmpassword)) {
        //    inputemail.setError("Password Not Match");
       // }
       // else {
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(signup.this, "Registration Successful .Kindly Login", Toast.LENGTH_SHORT).show();
                        sendUseToNextActivity();

                    }
                    else {
                        Toast.makeText(signup.this, "Enter Details"+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                    }

            });

      //  }
        }

    private void sendUseToNextActivity() {
        Intent intent=new Intent(signup.this,Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}



