package com.example.mojojojo.loginform;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

class My_adapterwishlist extends BaseAdapter {

    Context context;
    int wish_raw;
    String[]wishobj;
    int []wishimg;
    LayoutInflater ly;


    public My_adapterwishlist(Context context, int wish_raw, String[] wishobj, int[] wishimg) {

        this.context=context;
        this.wish_raw=wish_raw;
        this.wishobj=wishobj;
        this.wishimg=wishimg;

    }

    @Override
    public int getCount() {
        return wishobj.length;
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

        view=ly.from(context).inflate(wish_raw,null);
        ImageView imgviwobj=(ImageView)view.findViewById(R.id.wraw_imgid);
        TextView txtviewobj=(TextView)view.findViewById(R.id.wraw_txtid);
        ImageView imgdeleobj=(ImageView)view.findViewById(R.id.wraw_delete_id);
        imgviwobj.setImageResource(wishimg[i]);
        txtviewobj.setText(wishobj[i]);

        Picasso.get()
                .load(wishimg[i])
                .resize(50, 50)
               // .placeholder(R.drawable.user_placeholder)
               // .error(R.drawable.user_placeholder_error)
                .into(imgviwobj);
                //;
               // .centerCrop();
        return view;
    }


}
