package com.cognizant.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.entity.Product;
import com.cognizant.entity.User;
@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public boolean checkUser(String User,String Pass) {
		
		System.out.println(User+"   "+Pass);
		
		Session session=sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		Query query = session.createQuery("from User  where username=:User and password=:Pass");
		query.setParameter("User", User);
		query.setParameter("Pass",Pass);
		List<User> userList=query.list();
		
		tx.commit();
		sessionfactory.close();
		for(User userlist:userList)
		{return true;}
		
		{return false;}

}
}