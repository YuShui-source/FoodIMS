package com.mywork.controller;

import com.mywork.domain.Result;
import com.mywork.dto.*;
import com.mywork.po.OrderBody;
import com.mywork.po.PurchaseBody;
import com.mywork.service.BankService;
import com.mywork.service.OrderService;
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
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private BankService bankService;

    @GetMapping("/order")
    public String order() {
        return "order";
    }

    @GetMapping("/orderCount")
    @ResponseBody
    public Result getFood(){
        HttpSession session = SessionUtil.takeSession();
        String u_id = (String) session.getAttribute("u_id");
        int totalPages = orderService.getOrderCount(u_id)/10+1;
        return Result.ok(totalPages,200,"获取成功");
    }

    @GetMapping("/getOrder/{id}")
    @ResponseBody
    public Result getOrder(@PathVariable("id") Integer id){
        HttpSession session = SessionUtil.takeSession();
        String u_id = (String) session.getAttribute("u_id");
        List<String> ids = orderService.selectOrderId(u_id);
        List<Order> list = new ArrayList<>();
        for (int i = (id-1)*10; i < id*10; i++) {
            if (i<ids.size()&&!ids.get(i).isEmpty()){
                list.add(orderService.getOrder(ids.get(i)));
            }
        }
        return Result.ok(list,200,"获取成功");
    }

    @PostMapping("/addFoodOrder")
    public Result addFoodOrder(@Valid @RequestBody OrderBody orderBody){
        HttpSession session = SessionUtil.takeSession();
        String id = (String) session.getAttribute("u_id");
        if (orderService.addOrder(orderBody)) {
            String orderId = orderService.getOrderId(orderBody.getDemander(),orderBody.getFoodName());
            UserOrder userOrder = new UserOrder();
            userOrder.setU_id(id);
            userOrder.setO_id(orderId);
            if (orderService.addUserOrder(userOrder)){
                return Result.ok(200,"添加成功");
            }
        }
        return Result.error("添加失败");
    }

    @PostMapping("/updateOrder")
    @ResponseBody
    public Result updateOrder(@Valid @RequestBody OrderBody orderBody) {
        if (orderService.updateOrder(orderBody)) {
            return Result.ok(200, "修改成功");
        }
        return Result.error("修改失败");
    }

    @PostMapping("/sell")
    @ResponseBody
    public Result increaseBalance(@Valid @RequestBody OrderBody orderBody) {
        HttpSession session = SessionUtil.takeSession();
        String id = (String) session.getAttribute("u_id");
        String balance = (String) session.getAttribute("balance");
        float number = Float.parseFloat(orderBody.getNumber());
        float price = Float.parseFloat(orderBody.getDemanderPrice());
        float newBalance = Float.parseFloat(balance)+number*price;
        session.setAttribute("balance",String.format("%.2f",newBalance));
        if (bankService.updateBalance(id,String.format("%.2f",newBalance))) {
            this.deleteOrder(orderBody);
            return Result.ok(200, "购买成功");
        }
        return Result.error("购买失败");
    }

    @PostMapping("/deleteOrder")
    @ResponseBody
    public Result deleteOrder(@Valid @RequestBody OrderBody orderBody){
        String orderId = orderService.getOrderId(orderBody.getDemander(),orderBody.getFoodName());
        if (orderService.deleteOrder(orderId)&&orderService.deleteUserOrder(orderId)){
            return Result.ok(200,"删除成功");
        }
        return Result.error("删除失败");
    }
}
