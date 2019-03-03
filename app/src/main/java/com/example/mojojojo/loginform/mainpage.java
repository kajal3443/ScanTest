package com.example.mojojojo.loginform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mainpage extends AppCompatActivity {

    Button inmall;
    Button outmall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
        getSupportActionBar().hide();

        outmall=(Button)findViewById(R.id.outmall);
        inmall=(Button)findViewById(R.id.inmall);


        outmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(mainpage.this,categeory_list.class);
                startActivity(i1);

            }
        });

        inmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(mainpage.this,qrcodescan.class);
                startActivity(i2);

            }
        });
    }
}
