package com.niit.services;

import com.niit.models.Customer;
import com.niit.models.User;

public interface CustomerService
{
  public void registerCustomer (Customer customer);

  public boolean isEmailUnique(String email);

 public User getUser(String email);
}
