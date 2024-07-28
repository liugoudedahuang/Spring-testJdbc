package com.day5.dao.impl;

import com.day5.dao.BankDao;
import com.day5.entity.Bank;
import com.day5.tool.JdbcUtils;

import java.util.ArrayList;
import java.util.List;

/*
实现类
 */
public class BankDaoImpl implements BankDao {


    @Override
    public Bank selectBankByAccount(String fromAccount) {
        //准备SQL
        String sql="select * from t_bank where account=?";
        //调用jdbc工具类中方法执行SQL语句并得到结果
        JdbcUtils.rs= JdbcUtils.query(sql,fromAccount);
       // System.out.println("账号\t密码\t名称\t余额");

        // System.out.println(JdbcUtils.p.getProperty("url"));

        //声明一个对象集合存结果
        Bank b=null;
        //处理结果
        try{
            while (JdbcUtils.rs.next()){
                //创建对象存每行数据
                b=new Bank();

                b.setAccount(JdbcUtils.rs.getString("account"));
                b.setPassword(JdbcUtils.rs.getString("password"));
                b.setRealname(JdbcUtils.rs.getString("realname"));
                b.setMoney(JdbcUtils.rs.getDouble("money"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭对象
            JdbcUtils.closeObjectsAll(JdbcUtils.rs,JdbcUtils.state,JdbcUtils.conn);
        }
        return b;
    }

    /*@Override
    public int updateBank(Bank fromBank, double v) {
        //准备sql语句
        String sql="update t_bank set money=money+? where account=?";
        //调用jdbc工具类中方法执行SQL语句并得到结果
        int result= JdbcUtils.update(sql,v,fromBank);
        //关闭对象
        JdbcUtils.closeObjectsAll(JdbcUtils.conn,JdbcUtils.state,JdbcUtils.rs);
        return result;
    }*/
    @Override
    public int updateBank(String account, double v) {
        //准备sql语句
        String sql="update t_bank set money=money+? where account=?";
        //调用jdbc工具类中方法执行SQL语句并得到结果
        int result= JdbcUtils.update(sql,v,account);
        //关闭对象
        JdbcUtils.closeObjectsAll(JdbcUtils.conn,JdbcUtils.state,JdbcUtils.rs);
        return result;
    }
}
