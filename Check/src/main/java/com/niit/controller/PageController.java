package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
public  PageController()
{
	System.out.println("Pagecontroller bean is created");
}


	@RequestMapping(value = {"/","/home"})
	public ModelAndView getHomePage() {
		ModelAndView mv = new ModelAndView("home");
		return mv;
	
	}

}
