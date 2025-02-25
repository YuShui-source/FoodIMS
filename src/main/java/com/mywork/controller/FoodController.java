package com.mywork.controller;

import com.mywork.domain.Result;
import com.mywork.dto.Food;
import com.mywork.dto.UserFood;
import com.mywork.po.FoodBody;
import com.mywork.service.FoodService;
import com.mywork.util.SessionUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/inventory")
    public String inventory() {
        return "inventory";
    }

    @GetMapping("/foodCount")
    @ResponseBody
    public Result getFood(){
        HttpSession session = SessionUtil.takeSession();
        String u_id = (String) session.getAttribute("u_id");
        int totalPages = foodService.getFoodCount(u_id)/10+1;
        return Result.ok(totalPages,200,"获取成功");
    }

    @GetMapping("/food/{id}")
    @ResponseBody
    public Result getFood(@PathVariable("id") Integer id){
        HttpSession session = SessionUtil.takeSession();
        String u_id = (String) session.getAttribute("u_id");
        List<String> ids = foodService.selectFoodId(u_id);
        List<Food> list = new ArrayList<>();
        for (int i = (id-1)*10; i < id*10; i++) {
            if (i<ids.size()&&!ids.get(i).isEmpty()){
                list.add(foodService.getFood(ids.get(i)));
            }
        }
        return Result.ok(list,200,"获取成功");
    }

    @PostMapping("/addFoodInventory")
    public Result addFoodInventory(@Valid @RequestBody FoodBody foodBody){
        HttpSession session = SessionUtil.takeSession();
        String id = (String) session.getAttribute("u_id");
        if (foodService.addFood(foodBody)) {
            String foodId = foodService.getFoodId(foodBody.getName());
            UserFood userFood = new UserFood();
            userFood.setU_id(id);
            userFood.setF_id(foodId);
            if (foodService.addUserFood(userFood)){
                return Result.ok(200,"添加成功");
            }
        }
        return Result.error("添加失败");
    }

    @PostMapping("/updateFood")
    @ResponseBody
    public Result updateFood(@Valid @RequestBody FoodBody foodBody) {
        if (foodService.updateFood(foodBody)) {
            return Result.ok(200, "修改成功");
        }
        return Result.error("修改失败");
    }

    @PostMapping("/deleteFood")
    @ResponseBody
    public Result deleteFood(@Valid @RequestBody FoodBody foodBody){
        String foodId = foodService.getFoodId(foodBody.getName());
        if (foodService.deleteFood(foodId)&&foodService.deleteUserFood(foodId)){
            return Result.ok(200,"删除成功");
        }
        return Result.error("删除失败");
    }
}
