package com.mycomp.jdbctemplate.demo4;

public interface IAccountDao {

    void addMoney(String name, Double money);

    void minusMoney(String name, Double money);

}
