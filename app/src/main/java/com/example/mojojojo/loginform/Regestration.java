package com.example.mojojojo.loginform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Regestration extends AppCompatActivity {


    EditText fstnem;
    EditText emil;
    EditText pswd;
    EditText chpswd;
    EditText phno;
    Button b1;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regestration);
        getSupportActionBar().hide();
        fstnem = (EditText) findViewById(R.id.firstname);
        emil = (EditText) findViewById(R.id.email);
        pswd = (EditText) findViewById(R.id.password);
        chpswd = (EditText) findViewById(R.id.chanpassword);
        phno = (EditText) findViewById(R.id.phonenum);
        b1 = (Button) findViewById(R.id.okbtn);
        t1 = (TextView) findViewById(R.id.textview2);


        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Regestration.this, navigation.class);
                startActivity(i2);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (regvalidtion()) {
                    Call<ResponseBody> call = Config
                            .getmInstance()
                            .getApi()
                            .REG_URL(fstnem.getText().toString(), emil.getText().toString(), pswd.getText().toString(), phno.getText().toString());
                    call.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            JSONObject jsonObject = new JSONObject();
                            String s = jsonObject.toString();

                            Toast.makeText(Regestration.this, s, Toast.LENGTH_LONG).show();

                            Intent i1 = new Intent(Regestration.this, login.class);
                            startActivity(i1);
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Toast.makeText(Regestration.this, t.getMessage(), Toast.LENGTH_LONG).show();

                        }
                    });
                }
            }
        });
    }
        private boolean regvalidtion(){
            if (CommonUtil.isNullString(fstnem.getText().toString())) {
                fstnem.setError("check your first name");
            } else if (CommonUtil.isNullString(emil.getText().toString()) || !CommonUtil.checkEmail(emil.getText().toString())) {
                emil.setError("Check your Email");
            } else if (CommonUtil.isNullString(pswd.getText().toString()) || !CommonUtil.checkPassword(pswd.getText().toString())) {
                pswd.setError("Check your password");
            } else if (CommonUtil.isNullString(chpswd.getText().toString()) || !CommonUtil.checkPassword(chpswd.getText().toString())) {
                chpswd.setError("Check your confiram password");
            } else if (!(pswd.getText().toString().equals(chpswd.getText().toString()))) {
                pswd.setError("Mismatch password");
            } else if (phno.length() < 10 || phno.length() > 10) {
                phno.setError("Check your Phone number");
            } else {
                return true;
            }
            return false;
        }
    }