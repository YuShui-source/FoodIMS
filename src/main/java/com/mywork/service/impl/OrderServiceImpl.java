package com.mywork.service.impl;

import com.mywork.dto.Order;
import com.mywork.dto.UserOrder;
import com.mywork.mapper.OrderMapper;
import com.mywork.mapper.UserMapper;
import com.mywork.po.OrderBody;
import com.mywork.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Order getOrder(String o_id) {
        return orderMapper.getOrder(o_id);
    }

    @Override
    public int getOrderCount(String u_id) {
        return orderMapper.getOrderCount(u_id);
    }

    @Override
    public List<String> selectOrderId(String u_id) {
        return userMapper.getUserOrderId(u_id);
    }

    @Override
    public boolean addOrder(OrderBody po) {
        return orderMapper.addOrder(po.getDemander(), po.getFoodName(), po.getNumber(), po.getDemanderPrice());
    }

    @Override
    public boolean addUserOrder(UserOrder dto) {
        return orderMapper.addUserOrder(dto.getU_id(),dto.getO_id());
    }

    @Override
    public String getOrderId(String o_name, String f_name) {
        return orderMapper.getOrderId(o_name,f_name);
    }

    @Override
    public boolean updateOrder(OrderBody po) {
        return orderMapper.updateOrder(po.getDemander(), po.getFoodName(), po.getNumber(), po.getDemanderPrice());
    }

    @Override
    public boolean deleteOrder(String id) {
        return orderMapper.deleteOrder(id);
    }

    @Override
    public boolean deleteUserOrder(String id) {
        return orderMapper.deleteUserOrder(id);
    }
}
