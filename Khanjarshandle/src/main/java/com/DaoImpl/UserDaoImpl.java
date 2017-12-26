package com.DaoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dao.UserDao;
import com.model.User;

public class UserDaoImpl implements UserDao 
{
	@Autowired
	
	SessionFactory sessionFactory;
	
	@Autowired
	
	public UserDaoImpl()
	{
		super();
		this.sessionFactory=sessionFactory;
		
	}
public void insertUser(User user)
{
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	session.saveOrUpdate(user);
	session.getTransaction().commit();
}
}
