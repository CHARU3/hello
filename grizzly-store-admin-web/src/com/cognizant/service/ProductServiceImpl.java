package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cognizant.dao.ProductDAO;
import com.cognizant.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired@Qualifier("ProductDAOImpl")
	private ProductDAO productDAO;

	
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDAO.getAllProducts();
	}

	
	public List<String> getProductCategoryNames() {
		// TODO Auto-generated method stub
		return productDAO.getCategoriesName();
	}


	public boolean persistsProduct(Product product) {
		// TODO Auto-generated method stub
		return productDAO.insertProduct(product);
	}

	
	public int checkProduct(Product product) {
		// TODO Auto-generated method stub
		return productDAO.checkProduct(product);
	}


	@Override
	public boolean deleteproduct(int productid) {
		// TODO Auto-generated method stub
		
		return productDAO.deleteProduct(productid);
	}


	

}
