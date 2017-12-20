package controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController
{
	@RequestMapping("/")
	private ModelAndView fun1()
	{
		ModelAndView m1=new ModelAndView("index");
		return m1;
	}
    
}
