package com.cognizant.dao;

import java.util.List;

import com.cognizant.entity.Product;
import com.cognizant.entity.Vendor;

public interface VendorDAO {
	Vendor checkVendor(String userName,String password);
	 List<Product> getAllProducts();
}
