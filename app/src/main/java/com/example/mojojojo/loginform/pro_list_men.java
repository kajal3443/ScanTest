package com.example.mojojojo.loginform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class pro_list_men extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_list_men);
        getSupportActionBar().hide();
listView=(ListView)findViewById(R.id.prolist);
        int[] proimg = {R.drawable.men, R.drawable.men, R.drawable.men, R.drawable.men, R.drawable.men};
        String[] protxt = {"Formal Shirt","Formal Shirt","Formal Shirt","Formal Shirt","Formal Shirt",};
        String[] rs = {"Rs."};
        String[] price = {"300", "300", "300", "300", "300"};

        Pro_list_adpter pro_list_adpter = new Pro_list_adpter(pro_list_men.this, R.layout.pro_lismen_raw,
                proimg, protxt, rs, price);
        listView.setAdapter(pro_list_adpter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent i1=new Intent(pro_list_men.this,product_info.class);
                startActivity(i1);
            }
        });
    }
}
