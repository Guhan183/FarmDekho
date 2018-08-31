package com.farmdekho.info.farmdekho;

/**
 * Created by GUHAN on 24-03-2018.
 */

public class user {
    private String name;
    private String address;
    private String phone;
    private String quantity;
    private String date;
    private String crop;

    public user(String name, String address, String phone, String crop, String date, String quantity)
    {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.crop = crop;
        this.date = date;
        this.quantity = quantity;
    }
    public String getname() {
        return name;
    }
    public void setname(String name) {

        this.name = name;
    }
    public String getaddress() {
        return address;
    }
    public void setaddress(String address) {
        this.address = address;
    }
    public String getphone() {
        return phone;
    }
    public void setphone(String phone) {
        this.phone = phone;
    }
    public String getquantity() {
        return quantity;
    }
    public void setquantity(String quantity) {
        this.quantity = quantity;
    }
    public String getdate() {
        return date;
    }
    public void setdate(String date) {
        this.date = date;
    }
    public String getcrop() {
        return crop;
    }
    public void setcrop(String crop) {
        this.crop = crop;
    }
}


