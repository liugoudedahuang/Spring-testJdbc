package com.day5.ui;

import com.day5.service.BankService;
import com.day5.service.Impl.BankServiceImpl;

import java.util.Scanner;

/*
银行转账功能的表现层
 */
public class BankTest {
    public static void main(String[] args) {
        //1.接收用户输入的数据
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入转出账号：");
        String fromAccount=scanner.next();
        System.out.println("请输入转入账号：");
        String toAccount=scanner.next();
        System.out.println("请输入转账金额：");
        Double money=scanner.nextDouble();
        //2.调用业务层处理并得到结果
        BankService bankService=new BankServiceImpl();
        String res=bankService.changeMoney(fromAccount,toAccount,money);
        //3.将结果展示出来
        System.out.println(res);
    }
}
