package com.day5.entity;

public class Bank {
    private String account;
    private String password;
    private String realname;
    private Double money;

    @Override
    public String toString() {
        return "Bank{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", money=" + money +
                '}';
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
