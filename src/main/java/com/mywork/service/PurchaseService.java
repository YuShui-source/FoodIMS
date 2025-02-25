package com.mywork.service;

import com.mywork.dto.Purchase;
import com.mywork.dto.UserPurchase;
import com.mywork.po.PurchaseBody;

import java.util.List;

public interface PurchaseService {
    Purchase getPurchase(String p_id);

    int getPurchaseCount(String u_id);

    List<String> selectPurchaseId(String u_id);

    boolean addPurchase(PurchaseBody po);

    boolean addUserPurchase(UserPurchase dto);

    String getPurchaseId(String s_name, String f_name);

    boolean updatePurchase(PurchaseBody po);

    boolean deletePurchase(String id);

    boolean deleteUserPurchase(String id);
}
