package com.cognizant.dao;

import java.util.List;

import com.cognizant.entity.Product;

public interface ProductDAO {

	List<Product> getAllProducts();
	List<String> getCategoriesName();
	boolean insertProduct(Product product);
	int checkProduct(Product product);
	boolean deleteProduct(int productId);
}
