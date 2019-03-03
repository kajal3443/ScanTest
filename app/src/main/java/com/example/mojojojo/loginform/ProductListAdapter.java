package com.example.mojojojo.loginform;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mojojojo.loginform.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

class ProductListAdapter extends BaseAdapter {

    Context context;
    int[] proimg;
    int pro_lismen_raw;
    String[] protxt;
    String[] pro_detail;
    String[] rs;
    String[] price;
    LayoutInflater ly;

    List<Object> productList;

    public ProductListAdapter(ProductListActivity pro_list_men, int pro_lismen_raw, int[] proimg, String[] protxt, String[] pro_detail, String[] rs, String[] price) {
        this.context = pro_list_men;
        this.pro_lismen_raw = pro_lismen_raw;
        this.protxt = protxt;
        this.pro_detail = pro_detail;
        this.proimg = proimg;
        this.rs = rs;
        this.price = price;
    }

    public ProductListAdapter(Context productListActivity, int pro_lismen_raw, List<Object> productList) {
        this.context = productListActivity;
        this.productList=productList;
        this.pro_lismen_raw = pro_lismen_raw;
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
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = ly.from(context).inflate(pro_lismen_raw, null);
        ImageView iv = (ImageView) view.findViewById(R.id.proli_img);
        TextView tv = (TextView) view.findViewById(R.id.proli_txttitle);
        TextView tvdtail2 = (TextView) view.findViewById(R.id.pro_detail1);
        TextView tv2 = (TextView) view.findViewById(R.id.proli_txtrs);

        Product product= (Product) productList.get(i);

//        iv.setImageResource(product.);
        tv.setText(product.getProduct_name());
        tvdtail2.setText(product.getProduct_information());
        tv2.setText("Rs. " + product.getProduct_price());

        String imagePath = MyParam.imagePath + product.getImage_id();
        Picasso.get().load(imagePath).into(iv);

//        tv2.append(product.getProduct_price());


        return view;
    }
}
