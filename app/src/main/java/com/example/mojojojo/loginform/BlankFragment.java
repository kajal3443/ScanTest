package com.example.mojojojo.loginform;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.mojojojo.loginform.model.Product;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;


public class BlankFragment extends Fragment {

    ListView listview1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        container = (ViewGroup) inflater.inflate(R.layout.fragment_blank, container, false);
        listview1 = (ListView) container.findViewById(R.id.listviewid);


        if (MyParam.listWish.isEmpty()) {

            SharedPreferences preferences = getContext().getSharedPreferences("wish"
                    , MODE_PRIVATE);

            if (!preferences.getString("Wish", "").equals("")) {
                Gson gson = new Gson();
                Product[] products = gson.fromJson(preferences.getString("Wish", ""), Product[].class);

                List<Product> list = Arrays.asList(products);
                MyParam.listWish = new ArrayList<Object>(list);
            }

        }


//        My_adapterwishlist adapterwishlist = new My_adapterwishlist(getContext(),R.layout.wish_raw,wishobj,wishimg);
        My_adapterwishlist adapterwishlist = new My_adapterwishlist(getContext(), R.layout.wish_raw, MyParam.listWish);
        listview1.setAdapter(adapterwishlist);
        listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MyParam.selectedProduct = (Product) MyParam.listWish.get(i);
                Intent i1 = new Intent(getContext(), product_info.class);
                startActivity(i1);
            }
        });
        return container;
    }


}

