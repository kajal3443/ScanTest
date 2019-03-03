package com.example.mojojojo.loginform;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mojojojo.loginform.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

class My_adapterwishlist extends BaseAdapter {

    Context context;
    int wish_raw;
    String[]wishobj;
    int []wishimg;
    LayoutInflater ly;

    int pro_lismen_raw;
    List<Object> productList;


    public My_adapterwishlist(Context context, int wish_raw, String[] wishobj, int[] wishimg) {

        this.context=context;
        this.wish_raw=wish_raw;
        this.wishobj=wishobj;
        this.wishimg=wishimg;

    }

    public My_adapterwishlist(Context productListActivity, int pro_lismen_raw, List<Object> productList) {
        this.context = productListActivity;
        this.productList = productList;
        this.wish_raw = pro_lismen_raw;

    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        view=ly.from(context).inflate(wish_raw,null);
        ImageView imgviwobj=(ImageView)view.findViewById(R.id.wraw_imgid);
        TextView txtviewobj=(TextView)view.findViewById(R.id.wraw_txtid);
        ImageView imgdeleobj=(ImageView)view.findViewById(R.id.wraw_delete_id);
        LinearLayout container=view.findViewById(R.id.container);

        final Product product = (Product) productList.get(i);

        //imgviwobj.setImageResource(wishimg[i]);
        txtviewobj.setText(product.getProduct_name());

        String imagePath = MyParam.imagePath + product.getImage_id();
        Picasso.get().load(imagePath).into(imgviwobj);

        imgdeleobj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeItem(i);
            }
        });

//        container.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                MyParam.selectedProduct = product;
//                Intent i1 = new Intent(context, product_info.class);
//                context.startActivity(i1);
//            }
//        });
        return view;



    }

    private void removeItem(int position) {
        MyParam.listWish.remove(position);
        notifyDataSetChanged();
    }


}
