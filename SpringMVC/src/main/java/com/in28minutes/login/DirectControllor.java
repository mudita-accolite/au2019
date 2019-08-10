package com.in28minutes.login;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DirectControllor {
	
	@RequestMapping("/")
	public String redirectto(){
		return "firstpage";
	}
	@RequestMapping("/welcome")
	public String redirect(){
		return "firstpage";
	}
	@RequestMapping("/error")
	public String redirect2(){
		return "firstpage";
	}
}
