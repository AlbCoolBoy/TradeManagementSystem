package com.example.Bean;

public class Product {
    private String product_cd;
    private String name;
    private String product_type_cd;
    private String date_offered;

    public Product() {
    }

    public Product(String product_cd, String name, String product_type_cd, String date_offered) {
        this.product_cd = product_cd;
        this.name = name;
        this.product_type_cd = product_type_cd;
        this.date_offered = date_offered;
    }

    public String getProduct_cd() {
        return product_cd;
    }

    public void setProduct_cd(String product_cd) {
        this.product_cd = product_cd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduct_type_cd() {
        return product_type_cd;
    }

    public void setProduct_type_cd(String product_type_cd) {
        this.product_type_cd = product_type_cd;
    }

    public String getDate_offered() {
        return date_offered;
    }

    public void setDate_offered(String date_offered) {
        this.date_offered = date_offered;
    }
}
