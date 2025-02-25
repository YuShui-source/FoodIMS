package com.mywork.service.impl;

import com.mywork.dto.Purchase;
import com.mywork.dto.UserPurchase;
import com.mywork.mapper.PurchaseMapper;
import com.mywork.mapper.UserMapper;
import com.mywork.po.PurchaseBody;
import com.mywork.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Purchase getPurchase(String p_id) {
        return purchaseMapper.getPurchase(p_id);
    }

    @Override
    public int getPurchaseCount(String u_id) {
        return purchaseMapper.getPurchaseCount(u_id);
    }

    @Override
    public List<String> selectPurchaseId(String u_id) {
        return userMapper.getUserPurchaseId(u_id);
    }

    @Override
    public boolean addPurchase(PurchaseBody po) {
        return purchaseMapper.addPurchase(po.getSupplier(), po.getFoodName(), po.getNumber(), po.getFoodPrice());
    }

    @Override
    public boolean addUserPurchase(UserPurchase dto) {
        return purchaseMapper.addUserPurchase(dto.getU_id(),dto.getP_id());
    }

    @Override
    public String getPurchaseId(String s_name, String f_name) {
        return purchaseMapper.getPurchaseId(s_name,f_name);
    }

    @Override
    public boolean updatePurchase(PurchaseBody po) {
        return purchaseMapper.updatePurchase(po.getSupplier(), po.getFoodName(), po.getNumber(), po.getFoodPrice());
    }

    @Override
    public boolean deletePurchase(String id) {
        return purchaseMapper.deletePurchase(id);
    }

    @Override
    public boolean deleteUserPurchase(String id) {
        return purchaseMapper.deleteUserPurchase(id);
    }
}
