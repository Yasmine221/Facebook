package com.example.facebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.AsyncQueryHandler;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class Splash extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

      Handler handler = new Handler();
      handler.postDelayed(new Runnable() {
          @Override
          public void run() {
              Intent intent = new Intent(Splash.this,MainActivity.class);
              startActivity(intent);
          }
      },3000);
    }
}