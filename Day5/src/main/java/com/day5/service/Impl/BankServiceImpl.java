package com.day5.service.Impl;

import com.day5.dao.BankDao;
import com.day5.dao.impl.BankDaoImpl;
import com.day5.entity.Bank;
import com.day5.service.BankService;

public class BankServiceImpl implements BankService {

    /*
    创建数据访问对象
     */
    BankDao bankDao = new BankDaoImpl();

    /*
       转账功能：
       fromAccount转出账户
       toAccount转入账户
       money转账金额
        */
    @Override
    public String changeMoney(String fromAccount, String toAccount, Double money) {
        //1.处理业务逻辑
            //1.根据转出账号是否存在
        Bank fromBank=bankDao.selectBankByAccount(fromAccount);
        if(fromBank==null){
            return "转出账号不存在！！！";
        }
        //3.判断钱是否够
        if(fromBank.getMoney()<money){
            return "转出账号余额不足！！！";
        }
        //2.判断转入账号是否存在
        Bank toBank=bankDao.selectBankByAccount(toAccount);
        if(toBank==null){
            return "转入账号不存在！！！";
        }
        //4.转账功能
        //转出账号减钱
       // int result1=bankDao.updateBank(fromAccount,-money);
        int result1=bankDao.updateBank(fromAccount,-money);
        //转入账号加钱
        int result2=bankDao.updateBank(toAccount,money);
        if(result1>0&&result2>0){
            return "转账成功！";
        }else {
            return "转账失败！！！";
        }
    }
}
