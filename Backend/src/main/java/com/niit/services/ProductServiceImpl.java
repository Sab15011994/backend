package com.niit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.niit.dao.ProductDao;
import com.niit.models.Product;

public  class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDao productDao;
	public  ProductServiceImpl()
	{
		System.out.println("Product ServiceImpl bean is created");
	}

	@Override
	public void addProduct(Product product) {
		productDao.addProduct(product);
		
	}

	@Override
	public void updateProduct(Product product) {
		productDao.updateProduct(product);
		
	}

	@Override
	public void deleteProduct(int id) {
		productDao.deleteProduct(id);
		
	}

	@Override
	public Product getProduct(int id) {
		return productDao.getProduct(id);
		 
	}

	@Override
	public List<Product> getAllProducts() {
		
		return  productDao.getAllProducts(); 
	}

	
}
