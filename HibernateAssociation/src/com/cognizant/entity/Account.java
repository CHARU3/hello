package com.cognizant.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AccCog")
public class Account implements Serializable{
	
	@Id
	@Column(name="account_no")
	private int accountNO;
	
	@Column(name="account_type")
	private String accountType;
	
	@Column(name="account_balance")
	private double accountBalance;

	public int getAccountNO() {
		return accountNO;
	}

	public void setAccountNO(int accountNO) {
		this.accountNO = accountNO;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Override
	public String toString() {
		return "Account [accountNO=" + accountNO + ", accountType=" + accountType + ", accountBalance=" + accountBalance
				+ "]";
	}
	
	

}
