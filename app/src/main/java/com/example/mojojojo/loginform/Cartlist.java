package com.example.mojojojo.loginform;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class Cartlist extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartlist);


        listView=(ListView)findViewById(R.id.cart);

        String name[]={"Lee Cooper","Difference of Opinion"};

        String proinfo[]={"Men's Printed Regular Fit T-Shirt by Lee Cooper","Men's Cotton T-Shirt by Difference of Opinion"};

        String rs[]={"Rs."};

        String price[]={"1000","2000"};

        int img[]={R.drawable.cloth_man_1, R.drawable.cloth_man_1};


        Cart_list_adpeter cart_list = new Cart_list_adpeter(Cartlist.this,
                R.layout.cart_list_raw,name,proinfo,price,img,rs);

        listView.setAdapter(cart_list);

    }
}