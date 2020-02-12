package com.mycomp.jdbctemplate.demo3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext2.xml")
public class AccountServiceTest {

    @Resource(name = "accountService2")
    private IAccountService accountService;

    @Test
    public void test() {
        accountService.transferMoney("zzq1", "zzq2", 100d);
    }

}
