package com.backend.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.dao.SupplierDAO;
import com.backend.model.Supplier;



@Repository("supplierDAO")
public class SupplierDAOImpl  implements SupplierDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public SupplierDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	@Override
	public boolean createSupplier(Supplier supplier) 
	{
		
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		System.out.println("Insertion successful");
		return true;
		}
		
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
		
	}


}
