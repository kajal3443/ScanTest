package com.example.mojojojo.loginform;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Config {

    public static String BASE_URL="http://proglan.in/techmicra/scanandshop/";
//    Tech_micra_port=192.168.0.108
    public static Config mInstance;
    private Retrofit retrofit;

    private  Config(){
        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static synchronized Config getmInstance(){
        if(mInstance == null){
            mInstance = new Config();

        }
        return mInstance;
    }

    public user_interface getApi(){
        return retrofit.create(user_interface.class);
    }

}
