package com.mywork.controller;

import com.mywork.domain.Result;
import com.mywork.dto.*;
import com.mywork.po.OrderBody;
import com.mywork.po.PurchaseBody;
import com.mywork.service.BankService;
import com.mywork.service.PurchaseService;
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
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private BankService bankService;

    @GetMapping("/purchase")
    public String purchase() {
        return "purchase";
    }

    @GetMapping("/purchaseCount")
    @ResponseBody
    public Result getFood(){
        HttpSession session = SessionUtil.takeSession();
        String u_id = (String) session.getAttribute("u_id");
        int totalPages = purchaseService.getPurchaseCount(u_id)/10+1;
        return Result.ok(totalPages,200,"获取成功");
    }

    @GetMapping("/getPurchase/{id}")
    @ResponseBody
    public Result getPurchase(@PathVariable("id") Integer id){
        HttpSession session = SessionUtil.takeSession();
        String u_id = (String) session.getAttribute("u_id");
        List<String> ids = purchaseService.selectPurchaseId(u_id);
        List<Purchase> list = new ArrayList<>();
        for (int i = (id-1)*10; i < id*10; i++) {
            if (i<ids.size()&&!ids.get(i).isEmpty()){
                list.add(purchaseService.getPurchase(ids.get(i)));
            }
        }
        return Result.ok(list,200,"获取成功");
    }

    @PostMapping("/addFoodPurchase")
    public Result addFoodPurchase(@Valid @RequestBody PurchaseBody purchaseBody){
        HttpSession session = SessionUtil.takeSession();
        String id = (String) session.getAttribute("u_id");
        if (purchaseService.addPurchase(purchaseBody)) {
            String purchaseId = purchaseService.getPurchaseId(purchaseBody.getSupplier(),purchaseBody.getFoodName());
            UserPurchase userPurchase = new UserPurchase();
            userPurchase.setU_id(id);
            userPurchase.setP_id(purchaseId);
            if (purchaseService.addUserPurchase(userPurchase)){
                return Result.ok(200,"添加成功");
            }
        }
        return Result.error("添加失败");
    }

    @PostMapping("/updatePurchase")
    @ResponseBody
    public Result updatePurchase(@Valid @RequestBody PurchaseBody purchaseBody) {
        if (purchaseService.updatePurchase(purchaseBody)) {
            return Result.ok(200, "修改成功");
        }
        return Result.error("修改失败");
    }

    @PostMapping("/buy")
    @ResponseBody
    public Result reduceBalance(@Valid @RequestBody PurchaseBody purchaseBody) {
        HttpSession session = SessionUtil.takeSession();
        String id = (String) session.getAttribute("u_id");
        String balance = (String) session.getAttribute("balance");
        float number = Float.parseFloat(purchaseBody.getNumber());
        float price = Float.parseFloat(purchaseBody.getFoodPrice());
        float newBalance = Float.parseFloat(balance)-number*price;
        session.setAttribute("balance",String.format("%.2f",newBalance));
        if (bankService.updateBalance(id,String.format("%.2f",newBalance))) {
            this.deletePurchase(purchaseBody);
            return Result.ok(200, "购买成功");
        }
        return Result.error( "购买成功");
    }

    @PostMapping("/deletePurchase")
    @ResponseBody
    public Result deletePurchase(@Valid @RequestBody PurchaseBody purchaseBody){
        String purchaseId = purchaseService.getPurchaseId(purchaseBody.getSupplier(),purchaseBody.getFoodName());
        if (purchaseService.deletePurchase(purchaseId)&&purchaseService.deleteUserPurchase(purchaseId)){
            return Result.ok(200,"删除成功");
        }
        return Result.error("删除失败");
    }
}
