package com.Config; //day 4 info

import java.util.Properties;

import javax.sql.*;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import com.model.User;

public class HiberConfig 
{
	@Autowired //referes to the dispatcher servlet for the connection for bean 
	@Bean(name="datasource")
	public DataSource getH2data() //datasource is an interface its object is used as driver manager connection
	{
		DriverManagerDataSource  dsource=new DriverManagerDataSource();
		dsource.setDriverClassName("org.h2.Driver");
		dsource.setUrl("jdbc:h2:tcp://localhost/~/Khanjar");
		dsource.setUsername("sa");
		dsource.setPassword(" ");
		System.out.println("H2 connected");
		return dsource;
		
		
		
	}
   private Properties getHiber()
   {
	   Properties p=new Properties();
	   p.put("hibernate.dialect","org.hibernate.dialect.H2dialect");//auto generation of query(one of main use of hibernate
	   p.put("hibernate.hbm2ddl.auto","update");//for firing the query in the h2 database and transaction for dml and ddl
	   p.put("hibernate.show_sql", "true");
	   System.out.println("table created");
	   return p;
	   
	   
   }
@Autowired
@Bean(name="sessionFactory")

public SessionFactory getHibernateSession(DataSource datasource)
{
	LocalSessionFactoryBuilder lsfb=new LocalSessionFactoryBuilder(datasource);
	lsfb.addProperties(getHiber());
	lsfb.addAnnotatedClass(User.class);
	return lsfb.buildSessionFactory();
	
	
	
	
}
  
@Autowired
@Bean(name="transactionManager")

public HiberTransaction
}
