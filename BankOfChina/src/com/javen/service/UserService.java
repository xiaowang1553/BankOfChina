package com.javen.service;

import com.javen.bean.User;

public interface UserService {
   public String userRegisterValidate(String id);
   public void userRegister(User user);
}
