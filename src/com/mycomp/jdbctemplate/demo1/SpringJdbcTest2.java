package com.mycomp.jdbctemplate.demo1;

/*
 * Spring-JDBCTemplate的使用;
 * 使用spring的IOC, DI的方式访问数据库(spring代替我们管理数据源和jdbcTemplate)
 */

import com.mycomp.jdbctemplate.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringJdbcTest2 {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Test
    public void addTest() {
        jdbcTemplate.update("insert into account values (null, ?, ?)", "zzq233", 270.9d);
    }

    @Test
    public void deleteTest() {
        jdbcTemplate.update("delete from account where id = ?", 21);
    }

    @Test
    public void updateTest() {
        jdbcTemplate.update("update account set name = ?, money = ? where id = ?", "毛毛的大脚", 93.5d, 20);
    }

    @Test
    public void getTest1() {
        String name =
                jdbcTemplate.queryForObject("select name from account where id = ?", String.class, 20);
        System.out.println(name);
    }

    @Test
    public void getTest2() {
        Long count =
                jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(count);
    }

    @Test
    public void getTest3() {
        Account account =
                jdbcTemplate.queryForObject("select * from account where id = ?", new MyRowMap(), 20);
        System.out.println(account);
    }

    @Test
    public void getTest4() {
        List<Account> accounts = jdbcTemplate.query("select * from account", new MyRowMap());
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}

class MyRowMap implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getDouble("money"));
        return account;
    }
}
