package com.mywork.service;

import com.mywork.dto.Order;
import com.mywork.dto.UserOrder;
import com.mywork.po.OrderBody;

import java.util.List;

public interface OrderService {
    Order getOrder(String o_id);

    int getOrderCount(String u_id);

    List<String> selectOrderId(String u_id);

    boolean addOrder(OrderBody po);

    boolean addUserOrder(UserOrder dto);

    String getOrderId(String o_name, String f_name);

    boolean updateOrder(OrderBody po);

    boolean deleteOrder(String id);

    boolean deleteUserOrder(String id);
}
