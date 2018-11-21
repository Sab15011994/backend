package com.niit.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import com.niit.models.Authorities;
import com.niit.models.BillingAddress;
import com.niit.models.CartItem;
import com.niit.models.Category;
import com.niit.models.Customer;
import com.niit.models.Product;
import com.niit.models.ShippingAddress;
import com.niit.models.User;

@Component
public class DBConfiguration {
	public DBConfiguration()
	{
		System.out.println("DBConfiguration bean is created");
	}
	
	@Bean (name="dataSource")
	public  DataSource getDataSource()
	{
		System.out.println("Entering the database");
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/shopping");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		System.out.println("Datasource Bean" +dataSource);
		return dataSource;
		
		
	}
	@SuppressWarnings("rawtypes")
	@Bean (name="sessionFactory")
	 public SessionFactory getSessionFactory()
	{
	 System.out.println("Entering session Factory");
	 LocalSessionFactoryBuilder lsf = new LocalSessionFactoryBuilder(getDataSource());
	 Properties hibernateProperties = new Properties();
	 hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	 hibernateProperties.setProperty("hibernate.hbm2ddl.auto","update");
	 hibernateProperties.setProperty("hibernate.show_sql","true");
	 lsf.addProperties(hibernateProperties);
	 Class classes[] = new Class[] {Product.class,Category.class,User.class,Authorities.class,Customer.class,ShippingAddress.class,BillingAddress.class,CartItem.class};
	 System.out.println("SessionFactory Bean" +lsf);
	 return lsf.addAnnotatedClasses(classes).buildSessionFactory();
	 
	 
	 
	}
	@Bean (name="hibernateTransactionManager")
	public HibernateTransactionManager hibernateTransactionManager()
	{
		return new HibernateTransactionManager (getSessionFactory());
	}
	

}
