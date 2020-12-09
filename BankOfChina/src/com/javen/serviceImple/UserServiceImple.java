package com.javen.serviceImple;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javen.bean.SessionManager;
import com.javen.bean.User;
import com.javen.dao.IUserDao;
import com.javen.service.UserService;

@Service("userService")
public class UserServiceImple implements UserService{
	@Autowired
    private SessionManager sqlSessionManager;
    private SqlSession sqlSession;
    private IUserDao userDao;
	@Override
	public void userRegister(User user) {
		sqlSession=sqlSessionManager.getSession();
		userDao=sqlSession.getMapper(IUserDao.class);
		userDao.insertUser(user);
		sqlSessionManager.close();
	}
	@Override
	public String userRegisterValidate(String id) {
		sqlSession=sqlSessionManager.getSession();
		userDao=sqlSession.getMapper(IUserDao.class);
		List<User> users=userDao.selectAll();
		for(User user:users){
			if(id.equalsIgnoreCase(user.getId())){
				sqlSessionManager.close();
				return "Id existed";
			}
		}
		sqlSessionManager.close();
		return "success";
	}


}
