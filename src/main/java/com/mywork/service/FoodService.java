package com.mywork.service;

import com.mywork.dto.Food;
import com.mywork.dto.UserFood;
import com.mywork.po.FoodBody;

import java.util.List;

public interface FoodService {
    Food getFood(String f_id);

    int getFoodCount(String u_id);

    List<String> selectFoodId(String u_id);

    boolean addFood(FoodBody po);

    boolean addUserFood(UserFood dto);

    String getFoodId(String name);

    boolean updateFood(FoodBody po);

    boolean deleteFood(String id);

    boolean deleteUserFood(String id);

}
