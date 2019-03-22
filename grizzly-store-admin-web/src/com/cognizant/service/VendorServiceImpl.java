package com.cognizant.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.VendorDAO;
import com.cognizant.entity.Product;
import com.cognizant.entity.Vendor;

@Service
public class VendorServiceImpl implements VendorService{

	@Autowired
	private VendorDAO vendorDao;
	@Autowired
	private SessionFactory sessionFactory;
	
	public Vendor checkVendor(String userName,String password){
		return vendorDao.checkVendor(userName,password);
	}
	
	public List<Product> getAllProducts() {
		
		return vendorDao.getAllProducts();
}
}
