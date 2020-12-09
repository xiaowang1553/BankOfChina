package com.javen.bean;

import java.util.Date;

public class Account {
	private String id;
	private Integer accountNum;
	private String type;
	private String bankType;
	private double deposit;
	private double leftTransfer;
	private double leftWithdraw;
	private boolean isLost;
	private boolean isFrozen;
	private String password;
	private Date lastLogin;



	public double getLeftWithdraw() {
		return leftWithdraw;
	}

	public void setLeftWithdraw(double leftWithdraw) {
		this.leftWithdraw = leftWithdraw;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public double getLeftTransfer() {
		return leftTransfer;
	}

	public void setLeftTransfer(double leftTransfer) {
		this.leftTransfer = leftTransfer;
	}

	public boolean isLost() {
		return isLost;
	}

	public void setLost(boolean isLost) {
		this.isLost = isLost;
	}

	public Integer getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(Integer accountNum) {
		this.accountNum = accountNum;
	}

	public boolean isFrozen() {
		return isFrozen;
	}

	public void setFrozen(boolean isFrozen) {
		this.isFrozen = isFrozen;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountNum=" + accountNum + ", type="
				+ type + ", bankType=" + bankType + ", deposit=" + deposit
				+ ", leftTransfer=" + leftTransfer + ", leftWithdraw="
				+ leftWithdraw + ", isLost=" + isLost + ", isFrozen=" + isFrozen
				+ ", password=" + password + ", lastLogin=" + lastLogin + "]";
	}

}
