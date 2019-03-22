package com.cognizant.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DebitCog")
public class DebitCard implements Serializable{

	@Id
	@Column(name="card_no")
	private int cardNo;
	@Column(name="card_type")
	private String cardType;
	public int getCardNo() {
		return cardNo;
	}
	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	@Override
	public String toString() {
		return "DebitCard [cardNo=" + cardNo + ", cardType=" + cardType + "]";
	}
	
	
}
