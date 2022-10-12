package com.example.facebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
    private TextView logemail;
    private TextView logpassword;
    private TextView signUp;
    private Button login;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logemail = findViewById(R.id.email_txt);
        logpassword = findViewById(R.id.password_txt);
        login = findViewById(R.id.loging_btn);
        signUp = findViewById(R.id.signup_txt);

        auth = FirebaseAuth.getInstance();


      login.setOnClickListener(view -> {
          loginUser();
      });

      signUp.setOnClickListener(view -> {
          Intent i = new Intent(MainActivity.this,SignupActivity.class);
          startActivity(i);
      });

    }
    private void loginUser()
    {
        String email = logemail.getText().toString();
        String password = logpassword.getText().toString();

        if(TextUtils.isEmpty(email))
        {
          logemail.setError("Email cannot be Empty");
           logemail.requestFocus();
        }
        else if (TextUtils.isEmpty(password))
        {
            logpassword.setError("Password cannot be Empty");
          logpassword.requestFocus();
        }
        else
        {
            auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {
                        Toast.makeText(MainActivity.this, "User Logged in Successfully", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this,Homepage.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Login Failed" +task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }
}