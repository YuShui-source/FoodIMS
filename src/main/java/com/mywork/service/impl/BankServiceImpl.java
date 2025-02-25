package com.mywork.service.impl;

import com.mywork.mapper.BankMapper;
import com.mywork.mapper.UserMapper;
import com.mywork.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {

    @Autowired
    private BankMapper bankMapper;

    @Override
    public boolean updateBalance(String id, String balance) {
        return bankMapper.updateBalance(id,balance);
    }
}
