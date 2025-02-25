package com.mywork.controller;

import com.mywork.domain.Result;
import com.mywork.dto.Food;
import com.mywork.dto.Supplier;
import com.mywork.dto.UserFood;
import com.mywork.dto.UserSupplier;
import com.mywork.po.FoodBody;
import com.mywork.po.SupplierBody;
import com.mywork.service.FoodService;
import com.mywork.service.SupplierService;
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
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/supplier")
    public String supplier() {
        return "supplier";
    }

    @GetMapping("/supplierCount")
    @ResponseBody
    public Result getFood(){
        HttpSession session = SessionUtil.takeSession();
        String u_id = (String) session.getAttribute("u_id");
        int totalPages = supplierService.getSupplierCount(u_id)/10+1;
        return Result.ok(totalPages,200,"获取成功");
    }

    @GetMapping("/getSupplier/{id}")
    @ResponseBody
    public Result getSupplier(@PathVariable("id") Integer id){
        HttpSession session = SessionUtil.takeSession();
        String u_id = (String) session.getAttribute("u_id");
        List<String> ids = supplierService.selectSupplierId(u_id);
        List<Supplier> list = new ArrayList<>();
        for (int i = (id-1)*10; i < id*10; i++) {
            if (i<ids.size()&&!ids.get(i).isEmpty()){
                list.add(supplierService.getSupplier(ids.get(i)));
            }
        }
        return Result.ok(list,200,"获取成功");
    }

    @PostMapping("/addFoodSupplier")
    public Result addFoodSupplier(@Valid @RequestBody SupplierBody SupplierBody){
        HttpSession session = SessionUtil.takeSession();
        String id = (String) session.getAttribute("u_id");
        if (supplierService.addSupplier(SupplierBody)) {
            String supplierId = supplierService.getSupplierId(SupplierBody.getName());
            UserSupplier userSupplier = new UserSupplier();
            userSupplier.setU_id(id);
            userSupplier.setS_id(supplierId);
            if (supplierService.addUserSupplier(userSupplier)){
                return Result.ok(200,"添加成功");
            }
        }
        return Result.error("添加失败");
    }

    @PostMapping("/updateSupplier")
    @ResponseBody
    public Result updateSupplier(@Valid @RequestBody SupplierBody SupplierBody) {
        if (supplierService.updateSupplier(SupplierBody)) {
            return Result.ok(200, "修改成功");
        }
        return Result.error("修改失败");
    }

    @PostMapping("/deleteSupplier")
    @ResponseBody
    public Result deleteSupplier(@Valid @RequestBody SupplierBody SupplierBody){
        String supplierId = supplierService.getSupplierId(SupplierBody.getName());
        if (supplierService.deleteSupplier(supplierId)&&supplierService.deleteUserSupplier(supplierId)){
            return Result.ok(200,"删除成功");
        }
        return Result.error("删除失败");
    }
}
