package com.cognizant.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.entity.Product;
import com.cognizant.entity.Vendor;

@Repository("VendorDAOImpl")
public class VendorDAOImpl implements VendorDAO {
	

	@Autowired
	private SessionFactory sessionfactory;

	public Vendor checkVendor(String userName, String password) {
		
		
		Session session=sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		Query query = session.createQuery("from Vendor v  where v.userName=:User and v.password=:Pass");
		query.setParameter("User", userName);
		query.setParameter("Pass",password);
		List<Vendor> vendorList=query.list();
		System.out.println(vendorList);
		Vendor vendor=new Vendor();
		tx.commit();
		sessionfactory.close();
		for(Vendor vendorlist:vendorList)
		{
			vendor=vendorlist;
			
		}
		
		{return vendor;}
	}
	
	public List<Product> getAllProducts() {
		Session session=sessionfactory.openSession();
		List<Product>productList=session.createQuery("from Product").list();
		session.close();
		return productList;
	}

}
