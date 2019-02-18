package com.example.mojojojo.loginform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class forgot_pass extends AppCompatActivity {

    Button b1;
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);
        getSupportActionBar().hide();

        b1=(Button)findViewById(R.id.submit);
        e1=(EditText)findViewById(R.id.emilid);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1=new Intent(forgot_pass.this,Main3Activity.class);
                startActivity(i1);
            }
        });

    }
}
