package com.mywork.service;

import com.mywork.dto.Supplier;
import com.mywork.dto.UserSupplier;
import com.mywork.po.SupplierBody;

import java.util.List;

public interface SupplierService {
    Supplier getSupplier(String s_id);

    int getSupplierCount(String u_id);

    List<String> selectSupplierId(String u_id);

    boolean addSupplier(SupplierBody po);

    boolean addUserSupplier(UserSupplier dto);

    String getSupplierId(String name);

    boolean updateSupplier(SupplierBody po);

    boolean deleteSupplier(String id);

    boolean deleteUserSupplier(String id);
}
