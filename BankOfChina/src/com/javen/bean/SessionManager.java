package com.javen.bean;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionManager {
	private InputStream in;
	private String xmlResourceName;
	private SqlSession sqlSession;
   public SessionManager(String xmlResourceName) {
       	this.xmlResourceName=xmlResourceName;   
   }
   public SqlSession getSession(){
	   try {
		this.in=Resources.getResourceAsStream(xmlResourceName);
	} catch (IOException e) {
		e.printStackTrace();
	}
	   sqlSession=new SqlSessionFactoryBuilder().build(in).openSession();
	   return sqlSession;
   }
   public void close(){
	   sqlSession.commit();
	   sqlSession.close();
	   try {
		in.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
   }
}
