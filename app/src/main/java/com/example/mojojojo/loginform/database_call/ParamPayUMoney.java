package com.example.mojojojo.loginform.database_call;

public class ParamPayUMoney {
    private String transactionId = "123456";
    private String amount = "";
    private String phone = "9904475765";
    private String productName = "";
    private String firstName = "";
    private String email = "dhara1521@gmail.com";
    private String surl = "https://www.payumoney.com/mobileapp/payumoney/success.php";
    private String furl = "https://www.payumoney.com/mobileapp/payumoney/failure.php";
    private String udf1 = "";
    public static final String merchantKey = "f0MVfJm8";
    public static final String merchantId = "6652002";
    public static final String salt = "1S0BQdYfQK";

    private boolean isDebug = true;


    //Setter


    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSurl(String surl) {
        this.surl = surl;
    }

    public void setFurl(String furl) {
        this.furl = furl;
    }

    public void setUdf1(String udf1) {
        this.udf1 = udf1;
    }


    public void setDebug(boolean debug) {
        this.isDebug = debug;
    }


    //Getter


    public String getAmount() {
        return amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getPhone() {
        return phone;
    }

    public String getProductName() {
        return productName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getSurl() {
        return surl;
    }

    public String getFurl() {
        return furl;
    }

    public String getUdf1() {
        return udf1;
    }

    public String getMerchantKey() {
        return merchantKey;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public boolean isDebug() {
        return isDebug;
    }

    public String getSalt() {
        return salt;
    }
}
