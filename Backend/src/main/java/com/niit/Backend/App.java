package com.niit.Backend;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.configuration.DBConfiguration;
import com.niit.dao.ProductDao;
import com.niit.dao.ProductDaoImpl;
import com.niit.models.Product;
import com.niit.services.ProductService;
import com.niit.services.ProductServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context = new AnnotationConfigApplicationContext(DBConfiguration.class,ProductDaoImpl.class,ProductServiceImpl.class);
       ProductService productService = (ProductService) context.getBean("productServiceImpl");
       Product product = new Product();
       List<Product> products= productService.getAllProducts();
//       product.setId(3);
//       product.setProductname("Car");
//       product.setProductDesc("Lamborgini Car");
//       product.setPrice(400000);
//       product.setQuantity(2);
//       productService.addProduct(product);
//	     productService.deleteProduct(5);
//      productService.updateProduct(product);
//      Product p= productService.getProduct(1);
       for(Product p:products) {
     System.out.println(p.getId()+" "+p.getProductname()+" "+p.getProductDesc()+" "+p.getQuantity()+" "+p.getPrice());
    }
    }
}
