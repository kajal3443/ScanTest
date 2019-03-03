package com.example.mojojojo.loginform.model;



public class OrderDetails {


     /* Initialisation */

  private String Order_id = null;
  private String User_id = "";
  private String Product_id = "";
  private String Status_id = "";
  private String Order_amount = "";
  private String Order_date = "";
  private String Order_time = "";

     /* Setter */

  public String getOrder_id() {
    return Order_id;
  }

  public void setOrder_id(String order_id) {
    Order_id = order_id;
  }

  public String getUser_id() {
    return User_id;
  }

  public void setUser_id(String user_id) {
    User_id = user_id;
  }



  public String getProduct_id() {
    return Product_id;
  }

  public void setProduct_id(String product_id) {
    Product_id = product_id;
  }

  public String getStatus_id() {
    return Status_id;
  }

  public void setStatus_id(String status_id) {
    Status_id = status_id;
  }

  public String getOrder_amount() {
    return Order_amount;
  }

  public void setOrder_amount(String order_amount) {
    Order_amount = order_amount;
  }

  public String getOrder_date() {
    return Order_date;
  }

  public void setOrder_date(String order_date) {
    Order_date = order_date;
  }

  public String getOrder_time() {
    return Order_time;
  }

  public void setOrder_time(String order_time) {
    Order_time = order_time;
  }

  public class s {
       public static final String Order_id = "Order_id";
       public static final String User_id = "User_id";
       public static final String Product_id = "Product_id";
       public static final String Status_id = "Status_id";
       public static final String Order_amount = "Order_amount";
       public static final String Order_date = "Order_date";
       public static final String Order_time = "Order_time";
   }

}
