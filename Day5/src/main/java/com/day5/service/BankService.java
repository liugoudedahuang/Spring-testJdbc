package com.day5.service;
/*
银行的业务接口
 */
public interface BankService {
    /*
    转账功能：fromAccount转出账户 toAccount转入账户 money转账金额
     */
    String changeMoney(String fromAccount, String toAccount, Double money);
}
