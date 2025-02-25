package com.mywork.controller;

import com.mywork.domain.Result;
import com.mywork.po.LoginBody;
import com.mywork.service.UserService;
import com.mywork.util.SessionUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    private final HttpServletRequest request;

    @GetMapping("/login")
    public String login() {
        if (SessionUtil.isLogin(request)) {
            return "redirect:index";
        }
        return "login";
    }

    @GetMapping("/index")
    public String index() {

        return "index";
    }

    /**
     * 注册页
     */
    @GetMapping("/register")
    public String reg() {
        return "register";
    }

    @PostMapping("/login")
    @ResponseBody
    public Result<?> login(@Valid @RequestBody LoginBody body) {
        if (userService.doLogin(request,body)) {
            return Result.ok("登录成功");
        }
        return Result.error("登录失败");
    }

    @PostMapping("/register")
    @ResponseBody
    public Result<?> register(@Valid @RequestBody LoginBody dto) {
        if (userService.notExistUser(dto.getUsername())){
            if (userService.addUser(dto)) {
                return Result.ok("注册成功");
            }
        }
        return Result.error("注册失败");
    }

    @GetMapping("/logout")
    public String logout() {
        SessionUtil.deleteSession();
        return "redirect:login";
    }
}
