package com.example.mojojojo.loginform;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class pro_list_kid extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_list_kid);
        getSupportActionBar().hide();
        listView=(ListView)findViewById(R.id.prolist);

        String[] proid={"1","2","3","4"};

        int[] proimg = {R.drawable.kid1, R.drawable.kid2, R.drawable.kid3, R.drawable.kid4};

        String[] protxt = {"Girls' Ralph Lauren","T-Shirt","Round Neack T-Shirt","Newborn Baby Clothes"};

        String[] pro_detail ={
                "Striped Cotton Shirtdress",
                " Threadless T-Shirt " ,
                "After the Storm Kids T-shirt " ,
                "Newborn Baby Clothes Set Cotton Kid Clothing Boys Cartoon Long Sleeve T-Shirt+Pant"};
        String[] rs = {"Rs."};
        String[] price = {"300", "500", "1200", "1500"};

        Pro_list_kid_adpter pro_list_kid_adpter = new Pro_list_kid_adpter(pro_list_kid.this,R.layout.pro_lismen_raw,
                proimg, protxt, pro_detail, rs, price);
        listView.setAdapter(pro_list_kid_adpter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent i1=new Intent(pro_list_kid.this,product_info.class);
                startActivity(i1);
            }
        });
    }




    }



