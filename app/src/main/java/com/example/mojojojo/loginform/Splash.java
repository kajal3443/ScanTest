package com.example.mojojojo.loginform;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    //SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        SharedPreferences shapre = getSharedPreferences("user information", MODE_PRIVATE);
        final String restoreText = shapre.getString("email", "");

        Thread th = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    sleep(2000);
                    if (restoreText.equals("")) {

                        Intent i = new Intent(Splash.this, login.class);
                        startActivity(i);
                        finish();
                    } else {
                       MyParam.userEmail=restoreText;
                        Intent i = new Intent(Splash.this, mainpage.class);
                        startActivity(i);
                        finish();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        th.start();

    }
}
