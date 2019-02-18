package com.example.mojojojo.loginform;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        SharedPreferences shapre=getSharedPreferences("username",MODE_PRIVATE);
        final String restoreText=shapre.getString("name",null);
        Thread th=new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(4000);
                    if (restoreText == null) {
                        Intent i = new Intent(Splash.this, login.class);
                        startActivity(i);
                        finish();
                    } else {
                        Intent i = new Intent(Splash.this, navigation.class);
                        startActivity(i);

                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        th.start();

    }
}
