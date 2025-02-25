package com.mywork.dto;

public class Order {
    private String id;
    private String oname;
    private String fname;
    private String number;
    private String price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getO_name() {
        return oname;
    }

    public void setO_name(String oname) {
        this.oname = oname;
    }

    public String getF_name() {
        return fname;
    }

    public void setF_name(String fname) {
        this.fname = fname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", o_name='" + oname + '\'' +
                ", f_name='" + fname + '\'' +
                ", number='" + number + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
