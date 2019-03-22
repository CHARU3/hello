package com.cognizant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vendorLogin")
public class Vendor {
	@Id
	@Column(name="vendor_id")
	private String VendorID;
	@Column(name="userName")
	private String userName;
	@Column(name="password")
	private String password;
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
	public String getVendorID() {
		return VendorID;
	}
	public void setVendorID(String vendorID) {
		VendorID = vendorID;
	}
	

}
