package controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import com.backend.daoimpl.UserDAOImpl;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.backend.model.User;

@Controller
public class HomeController
{
	
	UserDAOImpl userDAOImpl;
	@RequestMapping("/")
	private ModelAndView fun1()
	{
		ModelAndView m1=new ModelAndView("index");
		return m1;
	}
	
	
    @RequestMapping(value="/goToRegister", method=RequestMethod.GET)
public ModelAndView goToRegister()
{
    	ModelAndView mv=new ModelAndView();
    	mv.addObject("user",new User());
    	mv.setViewName("register");
    	
    	return mv;  
}

    @RequestMapping(value="/goToRegister", method=RequestMethod.POST)
public ModelAndView saveRegister(@ModelAttribute("user")User user,BindingResult result)
{
        ModelAndView mv1=new ModelAndView();
        if(result.hasErrors())
        {
        	mv1.setViewName("register");
        	return mv1;
        }
        else
        {
        
        
        
        user.setRole("ROLE_USER");
        userDAOImpl.createUser(user);
        mv1.setViewName("index");
        return mv1;
        
        
    	
        }	
}
    
}


    
    
    