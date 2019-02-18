package com.example.mojojojo.loginform;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Mojo Jojo on 20-07-2018.
 */

class My_adapter extends BaseAdapter {

    Context con;
    int cat_raw;
    String[] catobj1;
    int[]testImage;
    LayoutInflater ly;

    public My_adapter(Context context,int cat_raw,String[]catobj1,int[]testImage)
    {
        this.con=context;
        this.cat_raw=cat_raw;
        this.catobj1=catobj1;
        this.testImage=testImage;

    }



    @Override
    public int getCount() {
        return catobj1.length;
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

        view=ly.from(con).inflate(cat_raw,null);
        ImageView im=(ImageView)view.findViewById(R.id.cat_img);
        TextView tx=(TextView)view.findViewById(R.id.cat_txt);
        im.setImageResource(testImage[i]);
        tx.setText(catobj1[i]);
        return view;
    }
}
