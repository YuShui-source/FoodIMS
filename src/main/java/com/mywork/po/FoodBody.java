package com.mywork.po;

import lombok.Data;

import java.sql.Date;

@Data
public class FoodBody {
    private String name;
    private String number;
    private Date expiration;
}
