package com.example.mojojojo.loginform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ProductListActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_list_men);

        getSupportActionBar().hide();

        listView = (ListView) findViewById(R.id.prolist);

        int key = getIntent().getIntExtra("key", -1);
        int sub_key = getIntent().getIntExtra("sub_key", -1);

        if (key == 0 && sub_key == 1) {
            String[] proid = {"1", "2", "3", "4"};

            int[] proimg = {R.drawable.cloth_man_1, R.drawable.men, R.drawable.cloth_man_3, R.drawable.cloth_man_4};

            String[] protxt = {"Cotton T-Shirt", "Formal Shirt", "Denim Shirt", "Leather Jacket"};

            String[] pro_detail = {"Urbano Fashion Men's Black, Yellow, Grey Round Neck Full Sleeve",
                    " Men Wear cotton Mens Shirts RM018 Color Black.: ",
                    " Goodthreads Men's Slim-Fit Short-Sleeve Denim Shirt ",
                    "Jack And Jones Compare Prices Buy Leather Jackets "};
            String[] rs = {"Rs."};
            String[] price = {"300", "500", "1200", "1500"};

            Pro_list_adpter pro_list_adpter = new Pro_list_adpter(ProductListActivity.this, R.layout.pro_lismen_raw,
                    proimg, protxt, pro_detail, rs, price);

            listView.setAdapter(pro_list_adpter); }

        else if (key == 0 && sub_key == 2)
        {
            String[] proid = {"1", "2", "3", "4"};

            int[] proimg = {R.drawable.cloth_woman_1, R.drawable.wompro1, R.drawable.womprod3, R.drawable.womprod4};

            String[] protxt = {"Kurti","Reversible Embroidered Jacket"," Cropped Shirt","Biker Jacket"};

            String[] pro_detail =
                    {"cotten kurti by khadim",
                            "Reversible Embroidered Bomber Jacket In BLACK ZAFUL",
                            "Cat Print Cropped Shirt PINK: Blouses  ZAFUL" ,
                            "  Zippered Lapel Collar Biker Jacket In Cheri Color  ZAFUL"};

            String[] rs = {"Rs."};

            String[] price = {"300", "500", "1200", "1500"};

            Pro_list_adpter pro_list_adpter = new Pro_list_adpter(ProductListActivity.this, R.layout.pro_lismen_raw,
                    proimg, protxt, pro_detail, rs, price);

            listView.setAdapter(pro_list_adpter);
        }

        else if (key == 0 && sub_key == 3)
        {
            String[] proid = {"1", "2", "3", "4"};

            int[] proimg = {R.drawable.kid1, R.drawable.kid2, R.drawable.kid3, R.drawable.kid4};

            String[] protxt = {"Girls' Ralph Lauren", "T-Shirt", "Round Neack T-Shirt", "Newborn Baby Clothes"};

            String[] pro_detail = {
                    "Striped Cotton Shirtdress",
                    " Threadless T-Shirt ",
                    "After the Storm Kids T-shirt ",
                    "Newborn Baby Clothes Set Cotton Kid Clothing Boys Cartoon Long Sleeve T-Shirt+Pant"};
            String[] rs = {"Rs."};
            String[] price = {"300", "500", "1200", "1500"};

            Pro_list_adpter pro_list_adpter = new Pro_list_adpter(ProductListActivity.this, R.layout.pro_lismen_raw,
                    proimg, protxt, pro_detail, rs, price);

            listView.setAdapter(pro_list_adpter);
        }
        /*watch category
        * */


        else if
        (key == 1 && sub_key == 1)
        {
            String[] proid = {"1", "2"};

            int[] proimg = {R.drawable.menwatch1, R.drawable.menwatch2};

            String[] protxt = {"Digital watch", "Piarso watch"};

            String[] pro_detail = {"Digital watch in brown color and black dial by Titan",
                    "Analog watch in black color"
                    };
            String[] rs = {"Rs."};
            String[] price = {"300", "500"};

            Pro_list_adpter pro_list_adpter = new Pro_list_adpter(ProductListActivity.this, R.layout.pro_lismen_raw,
                    proimg, protxt, pro_detail, rs, price);

            listView.setAdapter(pro_list_adpter);
        }

        else if
        (key == 1 && sub_key == 2)
        {
            String[] proid = {"1", "2"};

            int[] proimg = {R.drawable.womanwatch1, R.drawable.womenwatch2};

            String[] protxt = {"FastTrack", "Digital Watch"};

            String[] pro_detail = {"FastTrack watch for ladies in silver material",
                    " Digital watch for lady by TATA CLiq "
            };
            String[] rs = {"Rs."};
            String[] price = {"300", "500"};

            Pro_list_adpter pro_list_adpter = new Pro_list_adpter(ProductListActivity.this, R.layout.pro_lismen_raw,
                    proimg, protxt, pro_detail, rs, price);

            listView.setAdapter(pro_list_adpter);
        }

        else if
        (key == 1 && sub_key == 3)
        {
            String[] proid = {"1", "2"};

            int[] proimg = {R.drawable.kidwat1, R.drawable.kidwat2};

            String[] protxt = {"Barbie Watch", "Army Watch"};

            String[] pro_detail = {"Barbie watch with stylish dail",
                    " Army printed digital watch "
            };
            String[] rs = {"Rs."};
            String[] price = {"300", "500"};

            Pro_list_adpter pro_list_adpter = new Pro_list_adpter(ProductListActivity.this, R.layout.pro_lismen_raw,
                    proimg, protxt, pro_detail, rs, price);

            listView.setAdapter(pro_list_adpter);
        }

        /*Shoes category
         * */

        else if
        (key == 2 && sub_key == 1)
        {
            String[] proid = {"1", "2"};

            int[] proimg = {R.drawable.sportshoes1, R.drawable.lathershos2};

            String[] protxt = {"Sport shoes", "Lather Shoes"};

            String[] pro_detail = {"PUMA sport shoes in red",
                    " BATA  stylish lather shoes in brown color"
            };
            String[] rs = {"Rs."};
            String[] price = {"300", "500"};

            Pro_list_adpter pro_list_adpter = new Pro_list_adpter(ProductListActivity.this, R.layout.pro_lismen_raw,
                    proimg, protxt, pro_detail, rs, price);

            listView.setAdapter(pro_list_adpter);
        }

        else if
        (key == 2 && sub_key == 2)
        {
            String[] proid = {"1", "2"};

            int[] proimg = {R.drawable.womshoes1, R.drawable.womshoes2};

            String[] protxt = {"PUMA Shoes", "Leather Women Boots"};

            String[] pro_detail = {"PUMA  stylish shoes in  grey glittering effect",
                    "Autumn Winter Leather Women Boots With Pearls High Heel Ankle Boots With Metal Logo Waterproof Boots"
            };
            String[] rs = {"Rs."};
            String[] price = {"300", "500"};

            Pro_list_adpter pro_list_adpter = new Pro_list_adpter(ProductListActivity.this, R.layout.pro_lismen_raw,
                    proimg, protxt, pro_detail, rs, price);

            listView.setAdapter(pro_list_adpter);
        }

        else if
        (key == 2 && sub_key == 3)
        {
            String[] proid = {"1", "2"};

            int[] proimg = {R.drawable.kidshoe1, R.drawable.kidshoe2};

            String[] protxt = {"spiderman shoe", "Printed shoes"};

            String[] pro_detail = {"Spiderman shoes for kids",
                    " Printed Stylish shoes for girls "
            };
            String[] rs = {"Rs."};
            String[] price = {"300", "500"};

            Pro_list_adpter pro_list_adpter = new Pro_list_adpter(ProductListActivity.this, R.layout.pro_lismen_raw,
                    proimg, protxt, pro_detail, rs, price);

            listView.setAdapter(pro_list_adpter);

        }

/*
* Electronic category*/

        else if
        (key == 3)
        {
            String[] proid = {"1", "2"};

            int[] proimg = {R.drawable.electro1, R.drawable.electro2};

            String[] protxt = {"Sony LED TV", "Samsung M20 moblie"};

            String[] pro_detail = {"Sony LED TV 42cm HD display ",
                    " Samsung M20 4gb 32gb HD 13mp +5mp front camera "
            };
            String[] rs = {"Rs."};
            String[] price = {"300", "500"};

            Pro_list_adpter pro_list_adpter = new Pro_list_adpter(ProductListActivity.this, R.layout.pro_lismen_raw,
                    proimg, protxt, pro_detail, rs, price);

            listView.setAdapter(pro_list_adpter);
        }

        /*
         * Books category*/

        else if
        (key == 5)
        {
            String[] proid = {"1", "2"};

            int[] proimg = {R.drawable.book2, R.drawable.catbook};

            String[] protxt = {"The Girl in The Room 105", "The Perfect Us"};

            String[] pro_detail = {"The Girl in The Room 105 by Chetan Bhagat",
                    " The Perfect Us by Durjoy Dataa "
            };
            String[] rs = {"Rs."};
            String[] price = {"300", "500"};

            Pro_list_adpter pro_list_adpter = new Pro_list_adpter(ProductListActivity.this, R.layout.pro_lismen_raw,
                    proimg, protxt, pro_detail, rs, price);

            listView.setAdapter(pro_list_adpter);
        }

        /*
         * KIds toys category*/

        else if
        (key == 4)
        {
            String[] proid = {"1", "2"};

            int[] proimg = {R.drawable.kidtoy1, R.drawable.kidtoy2};

            String[] protxt = {"KTM Bike", "Little Puppy"};

            String[] pro_detail = {"KTM bike with battery charger for kids in white and saffron",
                    " Little puppy soft toy for kids "
            };
            String[] rs = {"Rs."};
            String[] price = {"300", "500"};

            Pro_list_adpter pro_list_adpter = new Pro_list_adpter(ProductListActivity.this, R.layout.pro_lismen_raw,
                    proimg, protxt, pro_detail, rs, price);

            listView.setAdapter(pro_list_adpter);
        }



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent i1 = new Intent(ProductListActivity.this, product_info.class);
                startActivity(i1);
            }
        });
    }
}
