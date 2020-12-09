package com.javen.serviceImple;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javen.bean.Account;
import com.javen.bean.SessionManager;
import com.javen.bean.Transaction;
import com.javen.dao.IAccountDao;
import com.javen.dao.ITransactionDao;
import com.javen.service.AccountService;

@Service("accountService")
public class AccountServiceImple implements AccountService {
   @Autowired
   SessionManager sqlSessionManager;
   @Autowired
   Transaction transaction;
@Override
public String withdrawOperation(Account account,String userId,Double amount, String password) {
	SqlSession sqlSession=sqlSessionManager.getSession();
	IAccountDao accountDao=sqlSession.getMapper(IAccountDao.class);
	ITransactionDao transactionDao=sqlSession.getMapper(ITransactionDao.class);
	if (password.equalsIgnoreCase(account.getPassword())) {
		if (amount < account.getLeftTransfer()) {
			if (account.getType().equalsIgnoreCase("信用卡账户")
					&& (account.getDeposit() - amount >= -2000)) {
				accountDao.accountWithdraw(amount, account.getAccountNum());
				transaction.setId(userId);
				transaction.setAccountNum(account.getAccountNum());
				transaction.setTransactionType("取款");
				transaction.setTransactionTime(new Date());
				transaction.setAmount(amount);
				transaction.setHandingFee((double)0);
				transactionDao.insertTransaction(transaction);
				sqlSessionManager.close();
				return "取款成功";
			}
			return "余额不足";
		}
		return "今日额度不足";
	}
	return "密码错误";
}
   
}
