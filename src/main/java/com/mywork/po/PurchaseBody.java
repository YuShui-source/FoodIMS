package com.mywork.po;

import lombok.Data;

@Data
public class PurchaseBody {
    private String foodName;
    private String supplier;
    private String number;
    private String foodPrice;
}
