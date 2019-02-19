package com.example.mojojojo.loginform;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class product_info extends AppCompatActivity {
    ImageButton addtowish;
    Button add_to_bag;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);
        getSupportActionBar().hide();

        add_to_bag = (Button)findViewById(R.id.add_to_bag);

        add_to_bag.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent addtobag=new Intent(product_info.this,Cartlist.class);
                startActivity(addtobag);
            }
        });
    }
}
