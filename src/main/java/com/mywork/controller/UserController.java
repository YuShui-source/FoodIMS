package com.mywork.controller;

import com.mywork.domain.Result;
import com.mywork.dto.Bank;
import com.mywork.po.UserBody;
import com.mywork.util.SessionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
public class UserController {

    @RequestMapping("/user")
    @ResponseBody
    public Result<?> user() {
        HttpSession session = SessionUtil.takeSession();
        UserBody userBody = new UserBody();
        String username = (String)session.getAttribute("username");
        String balance = (String)session.getAttribute("balance");
        userBody.setUsername(username);
        userBody.setBalance(balance);
        return Result.ok(userBody,200,"获取成功");
    }

}
