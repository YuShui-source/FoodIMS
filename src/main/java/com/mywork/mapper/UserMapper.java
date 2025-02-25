package com.mywork.mapper;

import com.mywork.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAll();
    User findUserByName(String name);
    int findUser(String name);
    boolean addUser(String username,String password);
    List<String> getUserFoodId(String u_id);
    List<String> getUserOrderId(String u_id);
    List<String> getUserPurchaseId(String u_id);
    List<String> getUserSupplierId(String u_id);
}
