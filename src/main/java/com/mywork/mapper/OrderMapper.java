package com.mywork.mapper;

import com.mywork.dto.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    Order getOrder(String o_id);
    int getOrderCount(String u_id);
    String getOrderId(String o_name,String f_name);
    boolean addOrder(String o_name, String f_name, String number, String price);
    boolean addUserOrder(String u_id, String o_id);
    boolean updateOrder(String o_name, String f_name, String number, String price);
    boolean deleteOrder(String id);
    boolean deleteUserOrder(String id);
}
