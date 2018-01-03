package com.backend.testcases;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.backend.dao.ProductDAO;
import com.backend.model.Product;

public class ProductTestCases {

	
	static ProductDAO productDAO;
	
	
	@BeforeClass
	public static void initalize()
	{
		System.out.println("Starting into Initializaed Product Test case ");
		
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.backend");
		annotationConfigAppContext.refresh();
		
		productDAO=(ProductDAO)annotationConfigAppContext.getBean("productDAO");
	
		System.out.println("Ending into Initializaed Product Test case ");
	}

	@Test
	public void createProductTest() 
	{
		
		System.out.println("Starting into Creating Blog Test case ");
		
		Product product=new Product();
		

		product.setId(10);
		product.setName("product1");
		product.setImgname("product1");
		product.setPrice(2000.10f);
		product.setStock(40);
		product.setDescription("Good Product");
		
		
		assertTrue("Problem in Product creation",productDAO.createProduct(product));
		
		System.out.println("Ending... into  Create Product Test case ");
	}


	
}
