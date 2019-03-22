package com.cognizant.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.cognizant.entity.Account;
import com.cognizant.entity.Customer;
import com.cognizant.entity.DebitCard;

public class PersistCustomer {

	public static void main(String[]args){
		
		AnnotationConfiguration configuration=new AnnotationConfiguration();
		configuration.configure();
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		DebitCard debit=new DebitCard();
		debit.setCardNo(1111);
		debit.setCardType("Platinum");
		
		Account account1=new Account();
		account1.setAccountNO(123);
		account1.setAccountType("Savings");
		account1.setAccountBalance(34000);	
		
		Account account2=new Account();
		account2.setAccountNO(456);
		account2.setAccountType("Current");
		account2.setAccountBalance(94000);	
		
		List<Account> accountList=new ArrayList<Account>();
		accountList.add(account1);
		accountList.add(account2);
		
		Customer customer=new Customer();
		customer.setCustId(101);
		customer.setCustName("charu");
		customer.setDebitCard(debit);
		customer.setAccounts(accountList);
		
		Transaction tx=session.getTransaction();
		tx.begin();
		session.persist(customer);
		tx.commit();
		
	}
}
