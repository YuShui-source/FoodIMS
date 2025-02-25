package com.mywork.dto;

public class UserFood {
    private String u_id;
    private String f_id;

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getF_id() {
        return f_id;
    }

    public void setF_id(String f_id) {
        this.f_id = f_id;
    }

    @Override
    public String toString() {
        return "UserFood{" +
                "u_id='" + u_id + '\'' +
                ", f_id='" + f_id + '\'' +
                '}';
    }
}
