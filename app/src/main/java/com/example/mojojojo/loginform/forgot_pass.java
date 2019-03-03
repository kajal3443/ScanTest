package com.example.mojojojo.loginform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mojojojo.loginform.database_call.NetworkCall;
import com.example.mojojojo.loginform.database_call.jsn;

import java.util.HashMap;

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
                forgetPassword();
                Intent i1=new Intent(forgot_pass.this,Main3Activity.class);
                startActivity(i1);
            }
        });

    }

    private void forgetPassword() {
        HashMap<String, String> param=new HashMap<>();
        param.put("type","forgetPassword");
        param.put("Email",e1.getText().toString());
        NetworkCall.call(param).setDataResponseListener(new NetworkCall.SetDataResponse() {
            @Override
            public void setResponse(String responseStr) {
                if (jsn.checkResponseStr(responseStr)) {
                    Toast.makeText(forgot_pass.this, "mail sent", Toast.LENGTH_SHORT).show();

                    Intent i1=new Intent(forgot_pass.this,login.class);
                    startActivity(i1);

                }else {
                    Toast.makeText(forgot_pass.this, "enter valid mail.", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
