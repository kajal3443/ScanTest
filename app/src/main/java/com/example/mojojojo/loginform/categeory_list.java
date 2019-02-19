package com.example.mojojojo.loginform;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

public class categeory_list extends AppCompatActivity {

    GridView grid1;
    ImageView img1;
    //CircleImageView ci;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categeory_list);

        // ci=(CircleImageView)findViewById(R.id.cmenimg);
        grid1 = (GridView) findViewById(R.id.g_catlist);

        String catobj1[] = {"CLOTHES", "WATCHES", "SHOES", "ELECTROICS",  "KIDS TOYS", "BOOKS"};
        int[] testImage = {R.drawable.clothe1, R.drawable.watch2, R.drawable.categoryshoes, R.drawable.electronics, R.drawable.toys, R.drawable.books1};

        My_adapter my_adpt = new My_adapter(this, R.layout.cat_raw, catobj1, testImage);
        grid1.setAdapter(my_adpt);

        grid1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {

                if (i == 0 || i == 1 || i == 2) {

                    Dialog dialog = new Dialog(categeory_list.this);
                    dialog.setContentView(R.layout.cloth_dialog1);
                    dialog.setTitle("Sub Category");
                    ImageView ln = (ImageView) dialog.findViewById(R.id.cmenimg);
                    System.out.println("ln ln ln :>"+ln);
                    ln.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            showProductList(i,1);
                        }
                    });
                    dialog.show();

                    ImageView wmn = (ImageView) dialog.findViewById(R.id.cwmenimg);
                    System.out.println("wmn wmn wmn :>"+wmn);
                    wmn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            showProductList(i,2);
                        }
                    });
                    dialog.show();

                    ImageView kid = (ImageView) dialog.findViewById(R.id.ckidimg);
                    kid.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            showProductList(i,3);
                        }
                    });
                    dialog.show();
                }else {
                    showProductList(i,-1);

                }
            }

        });

    }

    private void showProductList(int gridPosition, int subCaegoryPosition) {
        Intent i1 = new Intent(categeory_list.this, ProductListActivity.class);
        i1.putExtra("key",gridPosition);
        i1.putExtra("sub_key",subCaegoryPosition);
        startActivity(i1);
    }
}


