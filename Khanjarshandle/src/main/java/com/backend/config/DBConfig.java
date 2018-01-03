package com.backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.backend.dao.UserDAO;
import com.backend.daoimpl.UserDAOImpl;
import com.backend.model.Category;
import com.backend.model.Product;
import com.backend.model.Supplier;
import com.backend.model.User;

@Configuration
@ComponentScan("com.backend")
@EnableTransactionManagement

public class DBConfig 
{


	//1 creat datasource
	@Bean(name="dataSource")
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("org.h2.Driver");
		driverManagerDataSource.setUrl("jdbc:h2:tcp://localhost/~/test2");
		driverManagerDataSource.setUsername("sa");
		driverManagerDataSource.setPassword("sa");
		
		System.out.println("************************Database h2 is connected******************************");
		
		return driverManagerDataSource;		
		
	}
	
	//2creating hibernate properties

	public Properties getHibernateProperties()
	{
		Properties properties=new Properties();
		
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		System.out.println("Hibernate Proprty created");
		return properties;
	}
	
	
	//3 creating local session factory builder
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(getH2DataSource());
		localSessionFactoryBuilder.addProperties(getHibernateProperties());
		localSessionFactoryBuilder.addAnnotatedClass(User.class);
		localSessionFactoryBuilder.addAnnotatedClass(Category.class);
		localSessionFactoryBuilder.addAnnotatedClass(Supplier.class);
		localSessionFactoryBuilder.addAnnotatedClass(Product.class);
		
		System.out.println("SessionFactory Bean Created");
		return localSessionFactoryBuilder.buildSessionFactory();
	}
	
	
	//4. HibernateTransaction Bean
	
		@Bean(name= "transactionManager")
		public HibernateTransactionManager getHibernateTransactionMangaer(SessionFactory sessionFactory)
		{
			return new HibernateTransactionManager(sessionFactory);
		}

	
}
