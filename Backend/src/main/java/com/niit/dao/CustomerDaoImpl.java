package com.niit.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import com.niit.models.Authorities;
import com.niit.models.Customer;
import com.niit.models.User;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao 
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void registerCustomer(Customer customer) 
	{  
		System.out.println("Customer registering..");	
		Session session= sessionFactory.openSession();
	System.out.println("Customer registered");	
		User user = customer.getUser();
		Authorities authorities = user.getAuthorities();
		authorities.setUser(user);
		System.out.println(customer.getFirstname());
		
		session.save(customer);
		
		
		System.out.println("Customer registered");	
		}
	
    
	@Transactional
	@Override
	public boolean isEmailUnique(String email) {// james.s@niit.com
		Session session = sessionFactory.openSession();
		User user = (User) session.get(User.class, email);// select * from user where email='james.s@niit.com'
		if (user == null)// entered email is unique
			return true;
		else // entered email already exists in the table
			return false;
	}
	
	public User getUser(String email)
	{
		Session session =sessionFactory.openSession();
		User user = (User)session.get(User.class,email);
		return user;
	}
	
}
