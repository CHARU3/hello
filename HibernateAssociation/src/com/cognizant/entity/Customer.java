package com.cognizant.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="CustCog")
public class Customer {
	@Id
	@Column(name="cust_id")
	private int custId;
	
	@Column(name="cust_name")
	private String custName;
	
	@OneToOne(cascade=CascadeType.ALL, targetEntity=DebitCard.class)
	private DebitCard debitCard;
	
	@OneToMany(cascade=CascadeType.ALL, targetEntity=Account.class)
	private List<Account> accounts;

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public DebitCard getDebitCard() {
		return debitCard;
	}

	public void setDebitCard(DebitCard debitCard) {
		this.debitCard = debitCard;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", debitCard=" + debitCard + ", accounts="
				+ accounts + "]";
	}
	
	
	
}
