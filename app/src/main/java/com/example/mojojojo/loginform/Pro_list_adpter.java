package com.example.mojojojo.loginform;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class Pro_list_adpter  extends BaseAdapter{

    Context context;
    int[] proimg;
    int pro_lismen_raw;
    String[] protxt;
    String[] rs;
    String[] price;
    LayoutInflater ly;

    public Pro_list_adpter(pro_list_men pro_list_men, int pro_lismen_raw, int[] proimg, String[] protxt, String[] rs, String[] price) {
        this.context=pro_list_men;
        this.pro_lismen_raw=pro_lismen_raw;
        this.protxt=protxt;
        this.proimg=proimg;
        this.rs=rs;
        this.price=price;
        }

    @Override
    public int getCount() {
        return proimg.length;
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

        view=ly.from(context).inflate(pro_lismen_raw,null);
        ImageView iv=(ImageView)view.findViewById(R.id.proli_img);
        TextView tv=(TextView)view.findViewById(R.id.proli_txttitle);
        TextView tv2=(TextView)view.findViewById(R.id.proli_txtrs);
       iv.setImageResource(proimg[i]);
        tv.setText(protxt[i]);
        tv2.setText(rs[0]);
        tv2.append(price[i]);


        return view;
    }
}
