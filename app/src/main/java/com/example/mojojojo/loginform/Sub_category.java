package com.example.mojojojo.loginform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class Sub_category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);

        ListView listview = (ListView) findViewById(R.id.subct_listviw);
        Intent colth_intent = getIntent();
        int pos = colth_intent.getIntExtra("pos", -1);

        if (pos == 0) {

            String[] cloth_txt = {"MEN", "WOMEN", "KIDS"};
            int[] cloth_img = {R.drawable.men, R.drawable.clothe1, R.drawable.clothe1};


            Subcat_Adapter subcat_adapter = new Subcat_Adapter(Sub_category.this, R.layout.sub_cat_raw, cloth_txt, cloth_img);
            listview.setAdapter(subcat_adapter);

        } else if (pos == 1) {

            String[] watch_txt = {"watch1", "Watch2", "watch3"};
            int[] watch_img = {R.drawable.watch2, R.drawable.watch2, R.drawable.watch2};
            Subcat_Adapter subcat_adapter = new Subcat_Adapter(Sub_category.this, R.layout.sub_cat_raw, watch_txt, watch_img);
            listview.setAdapter(subcat_adapter);

        } else if (pos == 2) {

            String[] shoes_txt = {"shoes", "shoes2", "shoes3"};
            int[] shoes_img = {R.drawable.shoes, R.drawable.shoes, R.drawable.shoes};
            Subcat_Adapter subcat_adapter = new Subcat_Adapter(Sub_category.this, R.layout.sub_cat_raw, shoes_txt, shoes_img);
            listview.setAdapter(subcat_adapter);
        } else if (pos == 3) {

            String[] elect_txt = {"ele1", "ele2", "ele3"};
            int[] elect_img = {R.drawable.electronics, R.drawable.electronics, R.drawable.electronics};
            Subcat_Adapter subcat_adapter = new Subcat_Adapter(Sub_category.this, R.layout.sub_cat_raw, elect_txt, elect_img);
            listview.setAdapter(subcat_adapter);
        } else if (pos == 4) {

            String[] food_txt = {"food1", "food2", "food3"};
            int[] food_img = {R.drawable.grocerry1, R.drawable.grocerry1, R.drawable.grocerry1};
            Subcat_Adapter subcat_adapter = new Subcat_Adapter(Sub_category.this, R.layout.sub_cat_raw, food_txt, food_img);
            listview.setAdapter(subcat_adapter);
        } else if (pos == 5) {

            String[] kitch_txt = {"kitch1", "kitch2", "kitch3"};
            int[] kitch_img = {R.drawable.kitchen1, R.drawable.kitchen1, R.drawable.kitchen1};
            Subcat_Adapter subcat_adapter = new Subcat_Adapter(Sub_category.this, R.layout.sub_cat_raw, kitch_txt, kitch_img);
            listview.setAdapter(subcat_adapter);
        } else if (pos == 6) {

            String[] kids_txt = {"kid1", "kid2", "kid3"};
            int[] kids_img = {R.drawable.toys, R.drawable.toys, R.drawable.toys};
            Subcat_Adapter subcat_adapter = new Subcat_Adapter(Sub_category.this, R.layout.sub_cat_raw, kids_txt, kids_img);
            listview.setAdapter(subcat_adapter);
        } else if (pos == 7) {

            String[] book_txt = {"book", "book2", "book3"};
            int[] book_img = {R.drawable.books1, R.drawable.books1, R.drawable.books1};
            Subcat_Adapter subcat_adapter = new Subcat_Adapter(Sub_category.this, R.layout.sub_cat_raw, book_txt, book_img);
            listview.setAdapter(subcat_adapter);
        }

    }
}
