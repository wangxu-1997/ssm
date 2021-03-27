package com.wx;

import com.wx.dao.IAccountDao;
import com.wx.pojo.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;

import java.io.InputStream;
import java.util.List;

public class TestMyBatis {
    @Test
    public void run1() throws Exception {
        Account account = new Account();
        account.setName("张三");
        account.setMoney(2000d);
//        加载配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//        创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        创建SqlSession对象
        SqlSession session = sessionFactory.openSession();
//        获取代理对象
        IAccountDao accountDao = session.getMapper(IAccountDao.class);
        accountDao.saveAccount(account);
        session.commit();
        session.close();
        resourceAsStream.close();
    }

    @Test
    public void run2() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        IAccountDao mapper = session.getMapper(IAccountDao.class);
        List<Account> accounts = mapper.findAll();
        for (Account account : accounts) {
            System.out.println(account);
            System.out.println("gg");
        }
        session.close();
        inputStream.close();
    }

    @Test
    public void run3() {
        System.out.println(1 + 1 + 1);
    }
}
