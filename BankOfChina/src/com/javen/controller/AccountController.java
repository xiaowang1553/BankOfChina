package com.javen.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javen.bean.Account;
import com.javen.bean.SessionManager;
import com.javen.bean.Transaction;
import com.javen.bean.User;
import com.javen.dao.IAccountDao;
import com.javen.dao.ITransactionDao;
import com.javen.service.AccountService;

@Controller
public class AccountController {
	private ApplicationContext context;
	private SessionManager sessionManager;
	private SqlSession sqlSession;
	private HttpSession session;
	@Autowired
	private AccountService accountService;
	@Autowired
    private Transaction transaction;
	@RequestMapping(value="/withdraw",produces="text/html;charset=utf-8")
	@ResponseBody
	public String withdrawOperation(Double amount, String password,
			HttpServletRequest request) {
		session = request.getSession();
		User user=(User)session.getAttribute("userInfo");
		Account account = (Account) session.getAttribute("accountInfo");
		return accountService.withdrawOperation(account, user.getId(), amount, password);
	}
}
