package com.example.mojojojo.loginform;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {



    @SerializedName("Subscribe_id")
    public String Subscribe_id;
    @SerializedName("Subscribe_name")
    public String Subscribe_name;
    @SerializedName("Subscribe_email")
    public String Subscribe_email;
    @SerializedName("sub_password")
    public String sub_password;
    @SerializedName("Contac_no")
    public int Contac_no;
}
