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

        int key = getIntent().getIntExtra("key", -1);
if(key==0) {
    String[] proid = {"1", "2", "3", "4"};

    int[] proimg = {R.drawable.cloth_man_1, R.drawable.men, R.drawable.cloth_man_3, R.drawable.cloth_man_4};

    String[] protxt = {"Cotton T-Shirt", "Formal Shirt", "Denim Shirt", "Leather Jacket"};

    String[] pro_detail = {"Urbano Fashion Men's Black, Yellow, Grey Round Neck Full Sleeve",
            " Men Wear cotton Mens Shirts RM018 Color Black.: ",
            " Goodthreads Men's Slim-Fit Short-Sleeve Denim Shirt ",
            "Jack And Jones Compare Prices Buy Leather Jackets "};
    String[] rs = {"Rs."};
    String[] price = {"300", "500", "1200", "1500"};

    Pro_list_adpter pro_list_adpter = new Pro_list_adpter(pro_list_men.this, R.layout.pro_lismen_raw,
            proimg, protxt, pro_detail, rs, price);

    listView.setAdapter(pro_list_adpter);
}

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent i1=new Intent(pro_list_men.this,product_info.class);
                startActivity(i1);
            }
        });
    }
}
