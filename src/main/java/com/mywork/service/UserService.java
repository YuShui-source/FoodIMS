package com.mywork.service;

import com.mywork.po.LoginBody;

import javax.servlet.http.HttpServletRequest;

public interface UserService{
    boolean doLogin(HttpServletRequest request,LoginBody body);

    boolean addUser(LoginBody po);

    boolean notExistUser(String name);
}
