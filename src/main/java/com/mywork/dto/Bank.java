package com.mywork.dto;

public class Bank {
    private String u_id;
    private String balance;

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "u_id='" + u_id + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}
