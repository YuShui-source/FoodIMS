package com.mywork.mapper;

import com.mywork.dto.Food;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

@Mapper
public interface FoodMapper {
     Food getFood(String f_id);
     int getFoodCount(String u_id);
     String getFoodId(String name);
     boolean addFood(String name, String number, Date expiration);
     boolean addUserFood(String u_id,String f_id);
     boolean updateFood(String name, String number, Date expiration);
     boolean deleteFood(String id);
     boolean deleteUserFood(String id);
}
