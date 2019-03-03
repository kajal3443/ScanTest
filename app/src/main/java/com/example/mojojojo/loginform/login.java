package com.example.mojojojo.loginform;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Response;

public class login extends AppCompatActivity {

    TextView t1;
    TextView tt1;
    EditText e1;
    EditText e2;
    Button b1;
    Button b2;


    SharedPreferences sharedPreferences;
    SharedPreferences.Editor shaerdpre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        e1 = (EditText) findViewById(R.id.ed_1);
        e2 = (EditText) findViewById(R.id.ed_2);
        b1 = (Button) findViewById(R.id.bt1);
        b2 = (Button) findViewById(R.id.bt2);
        t1 = (TextView) findViewById(R.id.text);

        sharedPreferences = getSharedPreferences("user information"
                , MODE_PRIVATE);

        String email = sharedPreferences.getString("email", "");
        if (!email.equals("")) {
            MyParam.userEmail=email;
            Intent i1 = new Intent(login.this, mainpage.class);
            startActivity(i1);
            finish();
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                shaerdpre = sharedPreferences.edit();
                final String email = e1.getText().toString();
                shaerdpre.putString("email", email);
                shaerdpre.apply();
//                String s1= e1.getText().toString();
//                String s2 = e2.getText().toString();

                if (reglogin())
                {
                    retrofit2.Call<ResponseBody> call = Config
                            .getmInstance()
                            .getApi()
                            .login_URL(email, e2.getText().toString());
                    call.enqueue(new retrofit2.Callback<ResponseBody>()
                    {
                        @Override
                        public void onResponse(retrofit2.Call<ResponseBody> call, Response<ResponseBody> response)
                        {
                            JSONObject jsonObject = new JSONObject();
                            MyParam.userEmail = email;

                            String s = jsonObject.toString();

                            Toast.makeText(login.this,"login Successfully",Toast.LENGTH_LONG).show();

                            Intent i1 = new Intent(login.this, mainpage.class);
                            startActivity(i1);
                            finish();

                        }

                        @Override
                        public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t)
                        {
                            Toast.makeText(login.this,t.getMessage(),Toast.LENGTH_LONG).show();

                        }
                    });
                }
            }
        });


        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i1 = new Intent(login.this, Regestration.class);
                startActivity(i1);
            }

        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i2 = new Intent(login.this, forgot_pass.class);
                startActivity(i2);
            }
        });


    }

    private boolean reglogin() {
        if (CommonUtil.isNullString(e1.getText().toString()) || !CommonUtil.checkEmail(e1.getText().toString())) {
            e1.setError("check your email");
        } else if (CommonUtil.isNullString(e2.getText().toString()) || !CommonUtil.checkPassword(e2.getText().toString())) {
            e2.setError("Check your pasword");
        } else {
            return true;
        }
        return false;
    }
}
