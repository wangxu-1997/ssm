package com.wx.service.impl;

import com.wx.dao.IAccountDao;
import com.wx.pojo.Account;
import com.wx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private IAccountDao iAccountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("Service业务层：查询所有用户");
        return iAccountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        iAccountDao.saveAccount(account);
    }
}
