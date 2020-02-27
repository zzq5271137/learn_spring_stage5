package com.mycomp.jdbctemplate.demo1;

/*
 * Spring-JDBCTemplate的使用;
 * 使用传统的方式访问数据库(new对象的方式);
 */

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class SpringJdbcTest {

    @Test
    public void test() {
        // 1. 创建连接池(数据库相关信息)
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/myspring?useUnicode=true&characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("ZZQ930603");

        // 2. 创建JDBCTemplate, 这个template就是用来操作数据库的
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("insert into account values (null, ?, ?)", "zzq", 30.45d);
    }

}
