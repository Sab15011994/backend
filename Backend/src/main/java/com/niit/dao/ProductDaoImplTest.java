package com.niit.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.configuration.DBConfiguration;
import com.niit.models.Product;
import com.niit.services.ProductService;
import com.niit.services.ProductServiceImpl;

import junit.framework.TestCase;

public class ProductDaoImplTest extends TestCase 
{
	 ApplicationContext context = new AnnotationConfigApplicationContext(DBConfiguration.class,ProductDaoImpl.class,ProductServiceImpl.class);
     ProductService productService = (ProductService) context.getBean("productServiceImpl");
    public void testAddProduct()
    {
     Product p = new Product();
     p.setProductname("Sony");
     p.setProductDesc("HeadPhone");
     p.setPrice(2500);
     p.setQuantity(10);
     productService.addProduct(p);
     assertTrue(p.getId()>0);
}
}
