package com.mywork.service.impl;


import com.mywork.dto.Bank;
import com.mywork.po.LoginBody;
import com.mywork.dto.User;
import com.mywork.exception.MyException;
import com.mywork.mapper.BankMapper;
import com.mywork.mapper.UserMapper;
import com.mywork.service.UserService;
import com.mywork.util.SessionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final BankMapper bankMapper;

    @Override
    public boolean doLogin(HttpServletRequest request,LoginBody body) {

        User user = userMapper.findUserByName(body.getUsername());
        if (user == null){
            throw new MyException("用户不存在");
        }
        if (!body.getPassword().equals(user.getPassword())){
            throw new MyException("密码不正确");
        }
        Bank bank = bankMapper.findBankById(user.getId());
        return SessionUtil.login(request.getSession(),user, bank.getBalance());
    }

    @Override
    public boolean addUser(LoginBody po) {
        if (userMapper.addUser(po.getUsername(),po.getPassword())){
            return bankMapper.addBalance(userMapper.findUserByName(po.getUsername()).getId(),"10000");
        }else {
            return false;
        }
    }

    @Override
    public boolean notExistUser(String name) {
        return userMapper.findUser(name) == 0;
    }
}
