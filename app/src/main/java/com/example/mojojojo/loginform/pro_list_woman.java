package com.example.mojojojo.loginform;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.mojojojo.loginform.database_call.NetworkCall;

import java.util.HashMap;

public class pro_list_woman extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_list_woman);
        getSupportActionBar().hide();
        listView = (ListView) findViewById(R.id.prolist);

        String[] proid = {"1", "2", "3", "4"};

        int[] proimg = {R.drawable.cloth_woman_1, R.drawable.wompro1, R.drawable.womprod3, R.drawable.womprod4};

        String[] protxt = {"Kurti", "Reversible Embroidered Jacket", " Cropped Shirt", "Biker Jacket"};

        String[] pro_detail =
                {"cotten kurti by khadim",
                        "Reversible Embroidered Bomber Jacket In BLACK ZAFUL",
                        "Cat Print Cropped Shirt PINK: Blouses  ZAFUL",
                        "  Zippered Lapel Collar Biker Jacket In Cheri Color  ZAFUL"};

        String[] rs = {"Rs."};

        String[] price = {"300", "500", "1200", "1500"};

        Pro_list_woman_adpter pro_list_woman_adpter = new Pro_list_woman_adpter(pro_list_woman.this, R.layout.pro_lismen_raw,
                proimg, protxt, pro_detail, rs, price);
        listView.setAdapter(pro_list_woman_adpter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent i1 = new Intent(pro_list_woman.this, product_info.class);
                startActivity(i1);
            }
        });
    }
}

