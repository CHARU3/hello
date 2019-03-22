package com.cognizant.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Products")
@NamedQueries(
		{
			@NamedQuery(name="findAllProducts",query="select o from Product o"),
			@NamedQuery(name="checkProduct",query="select o from Product o where o.productId=?1 or o.productCategory=?2")
		})
public class Product {
	@Id
	@Column(name="product_Id")
	private int productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_category")
	private String productCategory;
	
	@Column(name="product_description")
	private String productDescription;
	
	@Column(name="product_price")
	private Double productPrice;
	
	@Transient
	@Column(name="brand")
	private String brand;
	
	@OneToOne(cascade=CascadeType.ALL, targetEntity=Vendor.class)
	private Vendor vendor;
	
	public Product() {}
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	
	

}
