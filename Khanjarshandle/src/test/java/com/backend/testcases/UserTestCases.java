package com.backend.testcases;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.backend.dao.UserDAO;
import com.backend.model.User;

public class UserTestCases {

	static UserDAO userDAO;
	
	
	@BeforeClass
	public static void initalize()
	{
		System.out.println("Starting into Initializaed Blog Test case ");
		
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.backend");
		annotationConfigAppContext.refresh();
		
		userDAO=(UserDAO)annotationConfigAppContext.getBean("userDAO");
	
		System.out.println("Ending into Initializaed User Test case ");
	}

	@Test
	public void createUserTest() 
	{
		
		System.out.println("Starting into Creating Blog Test case ");
		User user=new User();
		

		user.setEmail("srujana2@gmail.com");
		user.setName("Srujana2");
		user.setPassword("srujana2");
		user.setPhone("851984343");
		user.setRole("ROLE_USER");
		user.setEnabled("true");
		user.setAddress("Kukatpally, Hyderabad");

		assertTrue("Problem in blog creation",userDAO.createUser(user));
		
		System.out.println("Ending... into  Create User Test case ");
	}


	
}
