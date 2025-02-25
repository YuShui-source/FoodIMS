package com.mywork.mapper;

import com.mywork.dto.Supplier;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SupplierMapper {
    Supplier getSupplier(String s_id);
    int getSupplierCount(String u_id);
    String getSupplierId(String name);
    boolean addSupplier(String name, String supplier, String address);
    boolean addUserSupplier(String u_id,String s_id);
    boolean updateSupplier(String name, String supplier, String address);
    boolean deleteSupplier(String id);
    boolean deleteUserSupplier(String id);
}
