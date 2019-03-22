package com.cognizant.service;

import java.util.List;

import com.cognizant.entity.Product;
import com.cognizant.entity.Vendor;

public interface VendorService {
	Vendor checkVendor(String userName,String password);
	List<Product> getAllProducts();
}
