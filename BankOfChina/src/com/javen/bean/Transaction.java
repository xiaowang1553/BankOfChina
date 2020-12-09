package com.javen.bean;

import java.util.Date;

public class Transaction {
	private Integer index;
	private String id;
	private Integer accountNum;
	private String targetId;
	private Integer targetAccountNum;
	private String transactionType;
	private Date transactionTime;
	private Double amount;
	private Double handingFee;

	public Double getHandingFee() {
		return handingFee;
	}

	public void setHandingFee(Double handingFee) {
		this.handingFee = handingFee;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Date getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(Integer accountNum) {
		this.accountNum = accountNum;
	}

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public Integer getTargetAccountNum() {
		return targetAccountNum;
	}

	public void setTargetAccountNum(Integer targetAccountNum) {
		this.targetAccountNum = targetAccountNum;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Transaction [index=" + index + ", id=" + id + ", accountNum="
				+ accountNum + ", targetId=" + targetId + ", targetAccountNum="
				+ targetAccountNum + ", transactionType=" + transactionType
				+ ", transactionTime=" + transactionTime + ", amount=" + amount
				+ ", handingFee=" + handingFee + "]";
	}


}
