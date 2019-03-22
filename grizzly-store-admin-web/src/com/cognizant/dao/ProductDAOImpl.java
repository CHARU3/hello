package com.cognizant.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.entity.Product;
import com.cognizant.service.ProductService;

@Repository("ProductDAOImpl")
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> getAllProducts() {
		Session session=sessionFactory.openSession();
		List<Product>productList=session.createQuery("from Product").list();
		session.close();
		return productList;
	}

	@Override
	public List<String> getCategoriesName() {
		Session session=sessionFactory.openSession();
		Query query=session.createSQLQuery("select category_name from product_categories");
		List<String>categoryList=query.list();
		return categoryList;
	}

	@Override
	public boolean insertProduct(Product product) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.persist(product);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public int checkProduct(Product product) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product o where o.productId=:productId or o.productCategory=:productCategory");
		query.setInteger("productId",product.getProductId());
		query.setString("productCategory",product.getProductCategory());
		int productExists=0;
		List<Product>productList=query.list();
		for(Product productDB:productList){
			if(productDB.getProductId()==product.getProductId() && !(productDB.getProductCategory().equals(product.getProductCategory())) ){
				productExists=1;
				
			}else if(productDB.getProductCategory().equals(product.getProductCategory()) && !(productDB.getProductId()==product.getProductId())){
				productExists=2;
			}else if((productDB.getProductId()==product.getProductId()) && (productDB.getProductCategory().equals(product.getProductCategory()))){
				productExists=3;
			}
		}
		session.close();
		return productExists;
		
	}
	
	public boolean deleteProduct(int pID) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		System.out.println(pID);

		Query query = session.createQuery("delete from Product p where p.productId = :pID ");
		query.setParameter("pID", pID);
		int rows=query.executeUpdate();
		tx.commit();
		session.close();
		if(rows>0)
		return true;
		else
		return false;
	}

}
