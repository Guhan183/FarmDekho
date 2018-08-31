package com.farmdekho.info.farmdekho;

/**
 * Created by GUHAN on 06-07-2018.
 */

public class ProductItem1 {

    private String name="";
    private String address="";
    private String phone="";
    private String quantity="";
    private String date="";
    private String crop="";

    public ProductItem1(String name, String address, String phone, String quantity, String date, String crop) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.quantity = quantity;
        this.date = date;
        this.crop = crop;
    }

    public ProductItem1() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCrop() { return crop;}

    public void setNeed(String crop) {
        this.crop = crop;
    }


}
