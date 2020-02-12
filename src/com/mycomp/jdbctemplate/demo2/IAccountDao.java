package com.mycomp.jdbctemplate.demo2;

public interface IAccountDao {

    void addMoney(String name, Double money);

    void minusMoney(String name, Double money);

}
