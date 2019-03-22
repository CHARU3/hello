package com.cognizant.service;

import java.util.List;
import com.cognizant.entity.Product;


public interface ProductService {
	
	List<Product> getAllProducts();
	List<String> getProductCategoryNames();
	boolean persistsProduct(Product product);
	
	int checkProduct(Product product);
	boolean deleteproduct(int productid);
	
}
