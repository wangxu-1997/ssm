package com.wx.controller;

import com.wx.pojo.Account;
import com.wx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        System.out.println("Controller表现层，查询所有账户");
        List<Account> list = accountService.findAll();
        model.addAttribute("list", list);
        return "list";
    }

    @PostMapping("/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println(account);
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath() + "/account/findAll");
    }

}
