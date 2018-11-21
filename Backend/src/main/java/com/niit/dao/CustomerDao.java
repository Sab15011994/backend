package com.niit.dao;

import com.niit.models.Customer;
import com.niit.models.User;

public interface CustomerDao 
{
	public void registerCustomer (Customer customer);

	public boolean isEmailUnique(String email);

	public User getUser(String email);
}
