package com.mywork.dto;

public class UserOrder {
    private String u_id;
    private String o_id;

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getO_id() {
        return o_id;
    }

    public void setO_id(String o_id) {
        this.o_id = o_id;
    }

    @Override
    public String toString() {
        return "UserOrder{" +
                "u_id='" + u_id + '\'' +
                ", o_id='" + o_id + '\'' +
                '}';
    }
}
