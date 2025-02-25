package com.mywork.service.impl;

import com.mywork.dto.Supplier;
import com.mywork.dto.UserSupplier;
import com.mywork.mapper.SupplierMapper;
import com.mywork.mapper.UserMapper;
import com.mywork.po.SupplierBody;
import com.mywork.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierMapper supplierMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Supplier getSupplier(String s_id) {
        return supplierMapper.getSupplier(s_id);
    }

    @Override
    public int getSupplierCount(String u_id) {
        return supplierMapper.getSupplierCount(u_id);
    }

    @Override
    public List<String> selectSupplierId(String u_id) {
        return userMapper.getUserSupplierId(u_id);
    }

    @Override
    public boolean addSupplier(SupplierBody po) {
        return supplierMapper.addSupplier(po.getName(),po.getSupplier(),po.getAddress());
    }

    @Override
    public boolean addUserSupplier(UserSupplier dto) {
        return supplierMapper.addUserSupplier(dto.getU_id(),dto.getS_id());
    }

    @Override
    public String getSupplierId(String name) {
        return supplierMapper.getSupplierId(name);
    }

    @Override
    public boolean updateSupplier(SupplierBody po) {
        return supplierMapper.updateSupplier(po.getName(),po.getSupplier(),po.getAddress());
    }

    @Override
    public boolean deleteSupplier(String id) {
        return supplierMapper.deleteSupplier(id);
    }

    @Override
    public boolean deleteUserSupplier(String id) {
        return supplierMapper.deleteSupplier(id);
    }
}
