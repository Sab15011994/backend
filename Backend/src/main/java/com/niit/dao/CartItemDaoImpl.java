package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.models.CartItem;
import com.niit.models.CustomerOrder;
@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao {
	@Autowired
private SessionFactory sessionFactory;
	public void addToCart(CartItem cartItem) {
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(cartItem);//if cartItemId!=0, update query,if cartItemId==0,insert query
		session.flush();

	}
	public void removeCartItem(int cartItemId) {
		Session session=sessionFactory.openSession();
		CartItem cartItem=(CartItem)session.get(CartItem.class,cartItemId);
		session.delete(cartItem);
		session.flush();
		
	}
	public List<CartItem> getCart(String email) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from CartItem where user.email=?");
		query.setString(0, email);
		return query.list();
	}
	public CustomerOrder createCustomerOrder(CustomerOrder customerOrder) {
		Session session=sessionFactory.openSession();
		session.save(customerOrder);
		return customerOrder;
	}

}


