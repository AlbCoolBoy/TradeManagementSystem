package com.example.ManagerInfo;

public class Customer {
    private String cust_id;
    private String fed_id;
    private String address ;
    private String city;
    private String state;
    private String postal_code;

    public Customer() {
    }

    public Customer(String cust_id, String fed_id, String address, String city, String state, String postal_code) {
        this.cust_id = cust_id;
        this.fed_id = fed_id;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postal_code = postal_code;
    }

    public String getCust_id() {
        return cust_id;
    }

    public void setCust_id(String cust_id) {
        this.cust_id = cust_id;
    }

    public String getFed_id() {
        return fed_id;
    }

    public void setFed_id(String fed_id) {
        this.fed_id = fed_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

}
