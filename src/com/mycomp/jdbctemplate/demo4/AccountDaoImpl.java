package com.mycomp.jdbctemplate.demo4;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {

    /*
        如果继承了JdbcDaoSupport, 就不用写下面这些
        private JdbcTemplate jdbcTemplate;

        public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }
    */

    @Override
    public void addMoney(String name, Double money) {
        this.getJdbcTemplate().update("update account set money = money + ? where name = ?", money, name);
    }

    @Override
    public void minusMoney(String name, Double money) {
        this.getJdbcTemplate().update("update account set money = money - ? where name = ?", money, name);
    }
}
