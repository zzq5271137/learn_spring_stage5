package com.mycomp.jdbctemplate.demo4;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transferMoney(String from, String to, Double amount) {

        accountDao.minusMoney(from, amount);

        // 模拟异常发生
        int num = 1 / 0;

        accountDao.addMoney(to, amount);

    }

}
