package com.mywork.dto;

public class UserSupplier {
    private String u_id;
    private String s_id;

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    @Override
    public String toString() {
        return "UserSupplier{" +
                "u_id='" + u_id + '\'' +
                ", s_id='" + s_id + '\'' +
                '}';
    }
}
