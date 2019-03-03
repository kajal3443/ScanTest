

package com.example.mojojojo.loginform;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mojojojo.loginform.model.Product;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

class CartListAdapter extends BaseAdapter {

    Context context;
    int[] proimg;
    int pro_lismen_raw;
    String[] protxt;
    String[] pro_detail;
    List<Object> productList;
    String[] rs;
    String[] price;
    LayoutInflater ly;
    boolean isOrder = false;



    public CartListAdapter(Context productListActivity, int pro_lismen_raw, List<Object> productList) {
        this.context = productListActivity;
        this.productList = productList;
        this.pro_lismen_raw = pro_lismen_raw;

    }

    public CartListAdapter(Context productListActivity, int pro_lismen_raw, List<Object> productList, boolean isOrder, User_order user_order) {
        this.context = productListActivity;
        this.productList = productList;
        this.pro_lismen_raw = pro_lismen_raw;
        this.isOrder = isOrder;

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

        view = ly.from(context).inflate(pro_lismen_raw, null);
        ImageView iv = (ImageView) view.findViewById(R.id.cart_img);
        TextView tv = (TextView) view.findViewById(R.id.cart_txt1);
        TextView tvdtail2 = (TextView) view.findViewById(R.id.cart_txt2);
        TextView tv2 = (TextView) view.findViewById(R.id.cart_txt3);
        ImageView removeid = (ImageView) view.findViewById(R.id.cart_itm_remove);

        Product product = (Product) productList.get(i);


        tv.setText(product.getProduct_name());
        tvdtail2.setText(product.getProduct_information());
        tv2.setText("Rs. " + product.getProduct_price());


        String imagePath = MyParam.imagePath + product.getImage_id();
        Picasso.get().load(imagePath).into(iv);

//        tv2.append(product.getProduct_price());

        removeid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeItem(i);
            }
        });

        if (isOrder) {
            removeid.setVisibility(View.GONE);
        }

        return view;
    }


    private void removeItem(int position) {
        MyParam.listCart.remove(position);
        notifyDataSetChanged();

        SharedPreferences preferences= context.getSharedPreferences("cart",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();

        if (MyParam.listCart.size()== 0){
            editor.putString("Cart","");
            editor.apply();
        }

        else
        {
            Gson gson=new Gson();
            String s=gson.toJson(MyParam.listCart);
            editor.putString("Cart",s);
            editor.apply();
        }
        ((AppCompatActivity)context).recreate();
    }
}
