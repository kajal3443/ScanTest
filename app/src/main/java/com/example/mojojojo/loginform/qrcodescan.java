package com.example.mojojojo.loginform;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mojojojo.loginform.database_call.NetworkCall;
import com.example.mojojojo.loginform.database_call.jsn;
import com.example.mojojojo.loginform.model.Product;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

//implementing onclicklistener
public class qrcodescan extends AppCompatActivity implements View.OnClickListener {

    //View Objects
    private Button buttonScan;
   // private TextView textViewId;

    //qr code scanner object
    private IntentIntegrator qrScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qrcodescan);
        getSupportActionBar().hide();

        //View objects
        buttonScan = (Button) findViewById(R.id.buttonScan);
        //textViewId = (TextView) findViewById(R.id.textViewId);


        //intializing scan object
        qrScan = new IntentIntegrator(this);

        //attaching onclick listener
        buttonScan.setOnClickListener(this);
    }

    //Getting the scan results
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            //if qrcode has nothing in it
            if (result.getContents() == null) {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            } else {
                //if qr contains data
                try {
                    //converting the data to json
                    JSONObject obj = new JSONObject(result.getContents());
                    //setting values to textviews
                    String product_id = obj.getString("Product_id");
                   // textViewId.setText(product_id);
                    getProductInfo(product_id);

                } catch (JSONException e) {
                    e.printStackTrace();
                    //if control comes here
                    //that means the encoded format not matches
                    //in this case you can display whatever data is available on the qrcode
                    //to a toast
                    Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void getProductInfo(String product_id) {
        HashMap<String, String> param=new HashMap<>();
        param.put("type","getProduct");
        param.put("Product_id",product_id);
        NetworkCall.call(param).setDataResponseListener(new NetworkCall.SetDataResponse() {
            @Override
            public void setResponse(String responseStr) {
                if (jsn.checkResponseStr(responseStr)){
                    Product product = (Product) jsn.getSingleObjectFromString(responseStr, Product.class);
                    MyParam.selectedProduct = product;
                    Intent i1 = new Intent(qrcodescan.this, product_info.class);
                    startActivity(i1);
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        //initiating the qr code scan
        qrScan.initiateScan();
    }
}