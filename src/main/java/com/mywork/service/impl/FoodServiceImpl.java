package com.mywork.service.impl;

import com.mywork.dto.Food;
import com.mywork.dto.UserFood;
import com.mywork.mapper.FoodMapper;
import com.mywork.mapper.UserMapper;
import com.mywork.po.FoodBody;
import com.mywork.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodMapper foodMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Food getFood(String f_id) {
        return foodMapper.getFood(f_id);
    }

    @Override
    public int getFoodCount(String u_id) {
        return foodMapper.getFoodCount(u_id);
    }

    @Override
    public List<String> selectFoodId(String u_id) {
        return userMapper.getUserFoodId(u_id);
    }

    @Override
    public boolean addFood(FoodBody po) {
        return foodMapper.addFood(po.getName(),po.getNumber(),po.getExpiration());
    }

    @Override
    public boolean addUserFood(UserFood dto) {
        return foodMapper.addUserFood(dto.getU_id(),dto.getF_id());
    }

    @Override
    public String getFoodId(String name) {
        return foodMapper.getFoodId(name);
    }

    @Override
    public boolean updateFood(FoodBody po) {
        return foodMapper.updateFood(po.getName(), po.getNumber(), po.getExpiration());
    }

    @Override
    public boolean deleteFood(String id) {
        return foodMapper.deleteFood(id);
    }

    @Override
    public boolean deleteUserFood(String id) {
        return foodMapper.deleteUserFood(id);
    }
}
