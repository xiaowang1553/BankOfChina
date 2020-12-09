package com.javen.service;

import com.javen.bean.Account;

public interface AccountService {
     public String withdrawOperation(Account account,String userId,Double amount,String password);
}
