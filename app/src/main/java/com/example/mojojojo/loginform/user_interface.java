package com.example.mojojojo.loginform;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface user_interface {

    @FormUrlEncoded
    @POST("registration.php")
    Call<ResponseBody> REG_URL(
            //@Field("Subscribe_id")String Subscribe_id,
            @Field("Subscribe_name")String Subscribe_name,
            @Field("Subscribe_email")String Subscribe_email,
            @Field("sub_password")String sub_password,
            @Field("Contac_no")String Contac_no);


    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseBody> login_URL(
            @Field("Subscribe_email")String Subscribe_email,
            @Field("sub_password")String sub_password);


}
