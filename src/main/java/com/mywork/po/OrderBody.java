package com.mywork.po;

import lombok.Data;

@Data
public class OrderBody {
    private String foodName;
    private String demander;
    private String number;
    private String demanderPrice;
}
