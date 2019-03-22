package com.cognizant.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.UserDAO;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDao;
	@Autowired
	private SessionFactory sessionfactory;
	@Override
	public boolean checkUser(String User, String Pass) {
		return userDao.checkUser(User,Pass);
	}

}
