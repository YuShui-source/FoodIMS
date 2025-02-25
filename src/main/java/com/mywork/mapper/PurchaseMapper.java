package com.mywork.mapper;

import com.mywork.dto.Purchase;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PurchaseMapper {
    Purchase getPurchase(String p_id);
    int getPurchaseCount(String u_id);
    String getPurchaseId(String s_name,String f_name);
    boolean addPurchase(String s_name, String f_name, String number, String price);
    boolean addUserPurchase(String u_id, String p_id);
    boolean updatePurchase(String s_name, String f_name, String number, String price);
    boolean deletePurchase(String id);
    boolean deleteUserPurchase(String id);
}
