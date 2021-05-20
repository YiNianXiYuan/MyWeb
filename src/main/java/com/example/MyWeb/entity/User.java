package com.example.MyWeb.entity;

public class User {
    private String account;
    private String passWord;

    public User() {
    }

    public User(String account, String passWord) {
        this.account = account;
        this.passWord = passWord;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
