package com.javen.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.javen.bean.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.javen.bean.User;
import com.javen.dao.IAccountDao;
import com.javen.dao.IUserDao;
import com.javen.serviceImple.UserServiceImple;

@Controller
public class LoginController {  //登录用户
	private ApplicationContext context;
    private SessionManager sessionManager;
    private SqlSession sqlSession;
    private HttpSession session;
    @Autowired
    UserServiceImple userService;
	@RequestMapping("/login")
	String userLoginValidate(String id, String password,HttpServletRequest request) throws IOException { // 登录验证处理
		System.out.println(id + ":" + password);
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		sessionManager = (SessionManager) context.getBean("sqlSessionManager");
		sqlSession=sessionManager.getSession();
		IUserDao userDao = sqlSession.getMapper(IUserDao.class);
		List<User> users = userDao.selectAll();
		for (User user : users) {
			System.out.println(user.toString());
			if (user.getId().equalsIgnoreCase(id)
					&& user.getPassword().equalsIgnoreCase(password)) {
				if(user.getIsFrozen()==1){
					sessionManager.close();
					return "frozen";
				}
				session=request.getSession();
				session.setAttribute("userInfo", user);//将登录的用户信息保存在session中
				return "success";
			}
		}
		sessionManager.close();
		return "fail";
	}
	
	@RequestMapping("/userRegisterValidate")
	@ResponseBody
	String registerUserValidate(String id){ //注册用户前的验证
		return userService.userRegisterValidate(id);
	}
	
	@RequestMapping("/userRegister")
	String registerUser(User user){ //注册用户
		user.setIsFrozen(0);
	    userService.userRegister(user);
		return "success"; //注册成功
	}
	
	@RequestMapping("/accountLogin")
	String accountLoginValidated(String type,Integer accountNum,HttpServletRequest request){
		Date today;
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		sessionManager = (SessionManager) context
				.getBean("sqlSessionManager");
		sqlSession = sessionManager.getSession();
		IAccountDao accountDao=sqlSession.getMapper(IAccountDao.class);
		User user=(User)session.getAttribute("userInfo");
		Account account=accountDao.selectAccount(user.getId(), type, accountNum);
		if(account!=null){ //查有此账户，还需验证是否挂失、冻结
			if(account.isFrozen()){
	            return "frozen";
			}
			if(account.isLost()){
				return "lost";
			}
			today=new Date();
			if(account.getLastLogin()==null){
				account.setLastLogin(today);
			}
			Date lastLogin=account.getLastLogin();
			if(lastLogin.getDay()<today.getDay()){ //判断最后一次登录时间是否在今天之前
				account.setLeftTransfer(5000);
				account.setLastLogin(today);				
			}
			accountDao.updateByAccountNum(account);
			sessionManager.close();
			session.setAttribute("accountInfo", account);
			return "function";
		}
		sessionManager.close();
		return "fail";
	}
}
