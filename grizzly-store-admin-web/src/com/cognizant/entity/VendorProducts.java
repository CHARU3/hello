package com.cognizant.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="VProducts")
public class VendorProducts {
	@Id
	@Column(name="sno")
	private int SNo;
	
	@Column(name="brand")
	private String Brand;
	
	@Column(name="vendor_id")
	private int VId;
	
	@Column(name="quantity")
	private  int Quantity;
	
	@Column(name="product_id")
	private int PId;
	
	@OneToOne(cascade=CascadeType.ALL, targetEntity=Product.class)
	private Product product;
	
	@OneToOne(cascade=CascadeType.ALL, targetEntity=Vendor.class)
	private Vendor vendor;
	
	public int getSNo() {
		return SNo;
	}

	public void setSNo(int sNo) {
		SNo = sNo;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public int getVId() {
		return VId;
	}

	public void setVId(int vId) {
		VId = vId;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public int getPId() {
		return PId;
	}

	public void setPId(int pId) {
		PId = pId;
	}

	@Override
	public String toString() {
		return "VendorProdutcs [SNo=" + SNo + ", Brand=" + Brand + ", VId=" + VId + ", Quantity=" + Quantity + ", PId="
				+ PId + ", product=" + product + ", vendor=" + vendor + "]";
	}
	
	
	
}
