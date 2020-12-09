package com.javen.dao;

import org.apache.ibatis.annotations.Insert;

import com.javen.bean.Transaction;

public interface ITransactionDao {
	@Insert("insert into transaction(id,accountNum,transactionType,transactionTime,amount) values(#{id},#{accountNum},#{transactionType},#{transactionTime},#{amount})")
   void insertTransaction(Transaction transaction);
}
