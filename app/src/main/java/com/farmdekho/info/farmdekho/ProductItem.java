package com.farmdekho.info.farmdekho;

/**
 * Created by GUHAN on 05-07-2018.
 */

public class ProductItem {
    private String name="";
    private String address="";
    private String phone="";
    private String quantity="";
    private String date="";
    private String need="";

    public ProductItem(String name, String address, String phone, String quantity, String date, String need) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.quantity = quantity;
        this.date = date;
        this.need = need;
    }

    public ProductItem() {
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

    public String getNeed() {
        return need;
    }

    public void setNeed(String need) {
        this.need = need;
    }
}
