package com.example.facebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    EditText registerEmail,registerPassword,createAccount;
    Button registerBtn;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        auth = FirebaseAuth.getInstance();

        registerBtn = findViewById(R.id.register_btn);
        registerEmail = findViewById(R.id.email_txt_register);
        registerPassword = findViewById(R.id.password_txt_register);
        createAccount = findViewById(R.id.have_account);

       registerBtn.setOnClickListener(view -> {
           createUser();
       });

       createAccount.setOnClickListener(view -> {
           Intent i = new Intent(SignupActivity.this,MainActivity.class);
           startActivity(i);
       });

    }

    private void createUser() {

        String email = registerEmail.getText().toString();
        String password = registerPassword.getText().toString();

        if(TextUtils.isEmpty(email))
        {
            registerEmail.setError("Email cannot be Empty");
            registerEmail.requestFocus();
        }
        else if (TextUtils.isEmpty(password))
        {
            registerPassword.setError("Password cannot be Empty");
            registerPassword.requestFocus();

        }
        else
        {
            auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {
                        Toast.makeText(SignupActivity.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(SignupActivity.this,MainActivity.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(SignupActivity.this, "Regsteration Failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
        
    }
}