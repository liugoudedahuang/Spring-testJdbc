package com.day5.dao;

import com.day5.entity.Bank;

/*
银行数据访问接口
 */
public interface BankDao {

    Bank selectBankByAccount(String fromAccount);

    int updateBank(String fromAccount, double v);

    //  int updateBank(Bank fromBank, double v);

}
