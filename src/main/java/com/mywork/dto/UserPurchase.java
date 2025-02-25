package com.mywork.dto;

public class UserPurchase {
    private String u_id;
    private String p_id;

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    @Override
    public String toString() {
        return "UserPurchase{" +
                "u_id='" + u_id + '\'' +
                ", p_id='" + p_id + '\'' +
                '}';
    }
}
