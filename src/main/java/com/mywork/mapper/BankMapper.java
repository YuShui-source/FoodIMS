package com.mywork.mapper;

import com.mywork.dto.Bank;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BankMapper {
    List<Bank> findAll();
    Bank findBankById(String id);
    boolean addBalance(String id,String balance);
    boolean updateBalance(String id,String balance);
}
