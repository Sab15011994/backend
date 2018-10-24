package com.niit.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import com.niit.models.Product;

public class DBConfiguration {
	public DBConfiguration()
	{
		System.out.println("DBConfiguration bean is created");
	}
	
	@Bean
	public DataSource getDataSource()
	{
		System.out.println("Entering the database");
		BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:tcp://localhost/~/shopping");
		datasource.setUsername("sa");
		datasource.setPassword("sa");
		System.out.println("Datasource Bean" +datasource);
		return datasource;
		
		
	}
	@Autowired
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
	 Class classes[] = new Class[] {Product.class};
	 System.out.println("SessionFactory Bean" +lsf);
	 return lsf.addAnnotatedClasses(classes).buildSessionFactory();
	 
	 
	 
	}
	@Bean
	public HibernateTransactionManager hibernateTransactionManager()
	{
		return new HibernateTransactionManager (getSessionFactory());
	}
	

}
