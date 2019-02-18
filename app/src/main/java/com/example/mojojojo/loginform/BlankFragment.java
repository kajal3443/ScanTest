package com.example.mojojojo.loginform;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class BlankFragment extends Fragment {

ListView listview1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        container=(ViewGroup) inflater.inflate(R.layout.fragment_blank, container, false);
        listview1 = (ListView)container.findViewById(R.id.listviewid);

        String wishobj[] = {"PURSE", "SHOES", "WATCHES", "SHEDES"};
        int[] wishimg = {R.drawable.clothe1, R.drawable.shoes, R.drawable.watch2, R.drawable.smf};


        My_adapterwishlist adapterwishlist = new My_adapterwishlist(getContext(),R.layout.wish_raw,wishobj,wishimg);
        listview1.setAdapter(adapterwishlist);

            return  container;
    }

    }

