package com.backend.testcases;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.backend.dao.SupplierDAO;
import com.backend.model.Supplier;

public class SupplierTestcases {

	static SupplierDAO supplierDAO;
	
	
	@BeforeClass
	public static void initalize()
	{
		System.out.println("Starting into Initializaed Supplier Test case ");
		
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.backend");
		annotationConfigAppContext.refresh();
		
		supplierDAO=(SupplierDAO)annotationConfigAppContext.getBean("supplierDAO");
	
		System.out.println("Ending into Initializaed Supplier Test case ");
	}

	@Test
	public void createSupplierTest() 
	{
		
		System.out.println("Starting into Creating Supplier Test case ");
		Supplier supplier=new Supplier();
		


		supplier.setSid(100);
		supplier.setSupplierName("Rohit");
		assertTrue("Problem in Supplier creation",supplierDAO.createSupplier(supplier));
		
		System.out.println("Ending... into  Create Supplier Test case ");
	}


	
}
