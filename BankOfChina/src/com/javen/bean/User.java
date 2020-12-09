package com.javen.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable {
	private String id;
	private String userName;
	private String password;
	private String address;
	private Integer phoneNum;
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(Integer phoneNum) {
		this.phoneNum = phoneNum;
	}


	private Integer isFrozen;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getIsFrozen() {
		return isFrozen;
	}

	public void setIsFrozen(Integer isFrozen) {
		this.isFrozen = isFrozen;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password="
				+ password + ", address=" + address + ", phoneNum=" + phoneNum
				+ ", isFrozen=" + isFrozen + "]";
	}




}
