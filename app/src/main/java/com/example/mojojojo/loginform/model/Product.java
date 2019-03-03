package com.example.mojojojo.loginform.model;


public class Product {


     /* Initialisation */

  private String Product_id = null;
  private String Sub_category_id = "";
  private String Product_name = "";
  private String Product_price = "";
  private String Product_information = "";
  private String Product_status = "";
  private String Product_quantity = "";
  private String Image_id = "";
  private String Barcode_id = "";
  private String category_id = "";

  public String getProduct_id() {
    return Product_id;
  }

  public void setProduct_id(String product_id) {
    Product_id = product_id;
  }

  public String getSub_category_id() {
    return Sub_category_id;
  }

  public void setSub_category_id(String sub_category_id) {
    Sub_category_id = sub_category_id;
  }

  public String getProduct_name() {
    return Product_name;
  }

  public void setProduct_name(String product_name) {
    Product_name = product_name;
  }

  public String getProduct_price() {
    return Product_price;
  }

  public void setProduct_price(String product_price) {
    Product_price = product_price;
  }

  public String getProduct_information() {
    return Product_information;
  }

  public void setProduct_information(String product_information) {
    Product_information = product_information;
  }

  public String getProduct_status() {
    return Product_status;
  }

  public void setProduct_status(String product_status) {
    Product_status = product_status;
  }

  public String getProduct_quantity() {
    return Product_quantity;
  }

  public void setProduct_quantity(String product_quantity) {
    Product_quantity = product_quantity;
  }

  public String getImage_id() {
    return Image_id;
  }

  public void setImage_id(String image_id) {
    Image_id = image_id;
  }

  public String getBarcode_id() {
    return Barcode_id;
  }

  public void setBarcode_id(String barcode_id) {
    Barcode_id = barcode_id;
  }

  public String getCategory_id() {
    return category_id;
  }

  public void setCategory_id(String category_id) {
    this.category_id = category_id;
  }

  /* Table Name String */

   public class s {
       public static final String Product_id = "Product_id";
       public static final String Sub_category_id = "Sub_category_id";
       public static final String Product_name = "Product_name";
       public static final String Product_price = "Product_price";
       public static final String Product_information = "Product_information";
       public static final String Product_status = "Product_status";
       public static final String Product_quantity = "Product_quantity";
       public static final String Image_id = "Image_id";
       public static final String Barcode_id = "Barcode_id";
       public static final String category_id = "category_id";
   }

}
