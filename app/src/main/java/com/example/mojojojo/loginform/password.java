package com.example.mojojojo.loginform;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class password extends AppCompatActivity {
    TextView tx1;
    EditText t1;
    EditText t2;
    Button b1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
tx1=(TextView)findViewById(R.id.tx);
t1=(EditText) findViewById(R.id.change_pass);
t2=(EditText) findViewById(R.id.confirm_pass);
b1=(Button)findViewById(R.id.submit_pass);
    }
}
