package com.javen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Update;

import com.javen.bean.User;

public interface IUserDao {
	@Select("select * from user")
   List<User> selectAll();
	@Update("update user set lastLogin=#{lastLogin} where id=#{id}")
	void updateUser(User user);
	@Insert("insert into user(id,username,password,address,phoneNum,isFrozen) values(#{id},#{userName},#{password},#{address},#{phoneNum},#{isFrozen})")
	void insertUser(User user);
}
