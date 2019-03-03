package com.example.mojojojo.loginform;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mojojojo.loginform.model.Product;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class product_info extends AppCompatActivity {
    ImageButton addtowish;
    ImageView imageView;
    TextView name;
    TextView prodetail;
    TextView proprice;

    Button add_to_bag;
    private String imagePath;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);
        getSupportActionBar().hide();

        add_to_bag = (Button) findViewById(R.id.add_to_bag);
        name = findViewById(R.id.name);
        prodetail = findViewById(R.id.prodeatailid);
        imageView = findViewById(R.id.imageView);
        proprice = findViewById(R.id.pro_priceid);
        addtowish = findViewById(R.id.addtowish);

        final Product product = MyParam.selectedProduct;

        name.setText(product.getProduct_name());
        prodetail.setText(product.getProduct_information());
        proprice.setText("Rs. " + product.getProduct_price());

        imagePath = MyParam.imagePath + product.getImage_id();
        Picasso.get().load(imagePath).into(imageView);

        add_to_bag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyParam.listCart.add(product);

                SharedPreferences preferences = getSharedPreferences("cart"
                        , MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

                Gson gson = new Gson();
                String s = gson.toJson(MyParam.listCart);

                editor.putString("Cart", s);
                editor.apply();

                Intent addtobag = new Intent(product_info.this, Cartlist.class);
                startActivity(addtobag);
                finish();
            }
        });

        if (checkWish(product)) {
            addtowish.setImageResource(R.drawable.ic_favorite_black_24dp);
        }

        addtowish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (checkWish(product)) {
                    Toast.makeText(product_info.this, "Already in WishList", Toast.LENGTH_SHORT).show();
                } else {
                    MyParam.listWish.add(product);
                    addtowish.setImageResource(R.drawable.ic_favorite_black_24dp);
                    SharedPreferences preferences = getSharedPreferences("wish"
                            , MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();

                    Gson gson = new Gson();
                    String s = gson.toJson(MyParam.listWish);

                    editor.putString("Wish", s);
                    editor.apply();
                }
//                Intent addtowish=new Intent(product_info.this,categeory_list.class);
//                startActivity(addtowish);
            }
        });
    }

    public boolean checkWish(Product product) {
        return MyParam.listWish.contains(product);
    }
}
