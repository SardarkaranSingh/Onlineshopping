package com.backend.testcases;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.backend.dao.CategoryDAO;
import com.backend.model.Category;

public class CategoryTestCases {

	static CategoryDAO categoryDAO;
	
	
	@BeforeClass
	public static void initalize()
	{
		System.out.println("Starting into Initializaed Category Test case ");
		
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.backend");
		annotationConfigAppContext.refresh();
		
		categoryDAO=(CategoryDAO)annotationConfigAppContext.getBean("categoryDAO");
	
		System.out.println("Ending into Initializaed Category Test case ");
	}

	@Test
	public void createCategoryTest() 
	{
		
		System.out.println("Starting into Creating Blog Test case ");
		Category category=new Category();
		


		category.setCid(111);
		category.setName("Mobile");
		assertTrue("Problem in Category creation",categoryDAO.createCategory(category));
		
		System.out.println("Ending... into  Create Category Test case ");
	}


	
}
