package com.example.mojojojo.loginform;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.mojojojo.loginform.model.Product;
import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cartlist extends AppCompatActivity {

    ListView listView;
    Button backtocategory, Countinue;
    View cartempty;
    private CartListAdapter pro_list_adpter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartlist);


        listView = (ListView) findViewById(R.id.cart);
        backtocategory = (Button) findViewById(R.id.backtocategory);
        Countinue = (Button) findViewById(R.id.Countinue);
        cartempty=findViewById(R.id.cartempty);

        backtocategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(Cartlist.this, categeory_list.class);
                startActivity(i1);
            }
        });

        Countinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Cartlist.this, User_order.class);
                startActivity(i2);

            }
        });

        if (MyParam.listCart.isEmpty()) {

            SharedPreferences preferences = getSharedPreferences("cart"
                    , MODE_PRIVATE);

            if (!preferences.getString("Cart", "").equals("")) {

                listView.setVisibility(View.VISIBLE);
                cartempty.setVisibility(View.GONE);

                Gson gson = new Gson();
                Product[] products = gson.fromJson(preferences.getString("Cart", ""), Product[].class);

                List<Product> list = Arrays.asList(products);
                MyParam.listCart = new ArrayList<Object>(list);
            }
            else {
                listView.setVisibility(View.GONE);
                cartempty.setVisibility(View.VISIBLE);
            }

        }

        pro_list_adpter = new CartListAdapter(this, R.layout.cart_list_raw,
                MyParam.listCart);

        listView.setAdapter(pro_list_adpter);

    }


    @Override
    protected void onResume() {
        super.onResume();
        if (pro_list_adpter!=null){
            pro_list_adpter = new CartListAdapter(this, R.layout.cart_list_raw,
                    MyParam.listCart);

            listView.setAdapter(pro_list_adpter);

        }
    }
}