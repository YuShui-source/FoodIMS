package com.mywork.dto;

public class Purchase {
    private String id;
    private String sname;
    private String fname;
    private String number;
    private String price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getS_name() {
        return sname;
    }

    public void setS_name(String sname) {
        this.sname = sname;
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
        return "Purchase{" +
                "id='" + id + '\'' +
                ", s_name='" + sname + '\'' +
                ", f_name='" + fname + '\'' +
                ", number='" + number + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
