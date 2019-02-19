package com.example.mojojojo.loginform;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


class Cart_list_adpeter extends BaseAdapter {

    Context context;
    int  cart_list_raw;
    String[] name;
    String[] prinfo;
    String[] price;
    String[] rs;
    int[] img;
    LayoutInflater ly;

    public Cart_list_adpeter(Cartlist cartlist
            , int cart_list_raw
            , String[] name
            , String[] proinfo
            , String[] price
            , int[] img
            , String[] rs) {

        this.context = cartlist;
        this.cart_list_raw = cart_list_raw;
        this.name = name;
        this.prinfo=proinfo;
        this.price=price;
        this.rs=rs;
        this.img=img;


    }

    @Override
    public int getCount() {
        return name.length;
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
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = ly.from(context).inflate(cart_list_raw, null);

        ImageView cart_img = (ImageView) view.findViewById(R.id.cart_img);

        TextView cart_txt1 = (TextView) view.findViewById(R.id.cart_txt1);

        TextView cart_txt2 = (TextView) view.findViewById(R.id.cart_txt2);

        TextView cart_txt3 = (TextView) view.findViewById(R.id.cart_txt3);

        cart_img.setImageResource(img[i]);

        cart_txt1.setText(name[i]);

        cart_txt2.setText(prinfo[i]);

        cart_txt3.setText(rs[0]);
        cart_txt3.append( price[i]);

        return view;
    }
}
