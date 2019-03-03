package com.example.mojojojo.loginform;

import android.app.Notification;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.mojojojo.loginform.database_call.NetworkCall;
import com.example.mojojojo.loginform.database_call.ParamPayUMoney;
import com.example.mojojojo.loginform.database_call.PayUMoneyMain;
import com.example.mojojojo.loginform.database_call.jsn;
import com.example.mojojojo.loginform.model.OrderDetails;
import com.example.mojojojo.loginform.model.Product;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.os.Build.ID;

public class User_order extends AppCompatActivity {

    TextView totaldetail, totalprice, Rs_price, amountpay, amountRs;
    //Button cashpayment;
    Button onlinepayment;
    ListView userorder;
    int payumonytotal = 0;


    private HashMap<String, String> params = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_order);
        getSupportActionBar().hide();

       // cashpayment = (Button) findViewById(R.id.cashpayment);

        onlinepayment = (Button) findViewById(R.id.onlinepayment);

        totaldetail = (TextView) findViewById(R.id.totaldetail);

        totalprice = (TextView) findViewById(R.id.totalprice);

        Rs_price = (TextView) findViewById(R.id.Rs_price);

        amountpay = (TextView) findViewById(R.id.amountpay);

        amountRs = (TextView) findViewById(R.id.amountRs);

        userorder = findViewById(R.id.userorder);

//        cashpayment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Toast.makeText(User_order.this, "Successful Cash Payment", Toast.LENGTH_SHORT).show();
//
//                Intent i1 = new Intent(User_order.this, CashConfirm.class);
//                startActivity(i1);
//                saveOrder();
//                finish();
//
//            }
//        });

        onlinepayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startPayment();
            }

        });

        CartListAdapter pro_list_adpter = new CartListAdapter(this, R.layout.cart_list_raw,
                MyParam.listCart, true, User_order.this);

        userorder.setAdapter(pro_list_adpter);

        orderTotal();
    }

    PayUMoneyMain payment;

    //Order_amount
    public void startPayment() {
        payment = new PayUMoneyMain();
        ParamPayUMoney paramPayUMoney = new ParamPayUMoney();

        paramPayUMoney.setAmount(String.valueOf(payumonytotal));
        paramPayUMoney.setFirstName("abc");
        paramPayUMoney.setProductName("abcd");


        payment.startPaymentFlow(paramPayUMoney, this);
        payment.onResult().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean isSuccess) {
                if (isSuccess != null) {
                    if (isSuccess) {
                        Toast.makeText(User_order.this, "Successful payuMoney Payment", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(User_order.this, Cartlist.class);
                        startActivity(intent);

                        saveOrder();

                        MyParam.listCart = new ArrayList<>();
                        SharedPreferences preferences = User_order.this.getSharedPreferences("cart", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("Cart", "");
                        editor.apply();

                        finish();
                    } else {
                        Toast.makeText(User_order.this, "Transaction Fail...", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

    public void saveOrder() {

        for (Object o : MyParam.listCart) {
            Product product = (Product) o;

            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setOrder_amount(product.getProduct_price());
            orderDetails.setProduct_id(product.getProduct_id());
            orderDetails.setUser_id(MyParam.userEmail);

            HashMap<String, String> map = new HashMap<>();
            map = jsn.getMapForModel(orderDetails, "save");
            map.put("table", "order_details");
            Log.e("Order", "saveOrder: "+map.toString());

            NetworkCall.call(map).setDataResponseListener(new NetworkCall.SetDataResponse() {
                @Override
                public void setResponse(String responseStr) {
                    if (jsn.checkResponseStr(responseStr)) {
                        JSONObject jsonObjectAt0 = jsn.getJSONObjectAt0(responseStr);
                        String orderId=jsn.getJSONString(jsonObjectAt0,"id");
                        MyParam.listCart = new ArrayList<>();

                        SharedPreferences preferences = User_order.this.getSharedPreferences("cart", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("Cart", "");
                        editor.apply();
                        Log.e(TAG, "setResponse: "+responseStr );
                        sendMail(MyParam.userEmail,orderId);
                    }

                }
            });


        }

    }

    private static final String TAG = "User_order";
    private void sendMail(String userEmail, String orderId) {
        HashMap<String, String> param=new HashMap<>();
        param.put("type","saveOrderMail");
        param.put("Order_id",orderId);
        param.put("email",userEmail);
        Log.e(TAG, "sendMail: "+ param.toString());
        NetworkCall.call(param).setDataResponseListener(new NetworkCall.SetDataResponse() {
            @Override
            public void setResponse(String responseStr) {


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        payment.onResultActivity(requestCode, resultCode, data);
    }


    public void orderTotal() {
        int total = 0;
        int item = 0;
        payumonytotal=0;
        for (Object o : MyParam.listCart) {
            item++;
            Product product = (Product) o;

            total += Integer.parseInt(product.getProduct_price());
            payumonytotal = total;
        }

        totalprice.setText("Price(Itmes : " + item + ")");

        Rs_price.setText("Rs. " + total);

        amountRs.setText("Rs. " + total);

    }

}
