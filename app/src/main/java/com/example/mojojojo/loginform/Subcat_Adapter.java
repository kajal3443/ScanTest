package com.example.mojojojo.loginform;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class Subcat_Adapter extends BaseAdapter{

    Context context;
    int sub_cat_raw;
    String[] cloth_txt;
    int[] cloth_img;
    LayoutInflater ly;

    public Subcat_Adapter(Context context, int sub_cat_raw, String[] cloth_txt, int[] cloth_img) {

        this.context=context;
        this.sub_cat_raw=sub_cat_raw;
        this.cloth_txt=cloth_txt;
        this.cloth_img=cloth_img;

    }

    @Override
    public int getCount() {
        return cloth_txt.length;
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

        view=ly.from(context).inflate(sub_cat_raw,null);
        ImageView subimgobj=(ImageView)view.findViewById(R.id.subcat_img_id);
        TextView subtxtobj=(TextView)view.findViewById(R.id.subcat_txt_id);
        subimgobj.setImageResource(cloth_img[i]);
        subtxtobj.setText(cloth_txt[i]);



        return view;
    }
}
