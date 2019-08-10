package com.in28minutes.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.in28minutes.login.LoginService;


public class PreviousLoginController {
	@RequestMapping(value="/home") 	
	public String start() {
			return "firstpage"; 
		}
//	private LoginService loginService=new LoginService();
	@Autowired
	LoginService loginService;
	@RequestMapping(value="/login", method= RequestMethod.GET) 	
public String sayHello() {
		return "login"; 
	}
	
@RequestMapping(value="/login", method= RequestMethod.POST) 
	
	public String sayHello1(@RequestParam String name, @RequestParam String password, ModelMap model) {

	if (!loginService.validateUser(name, password)) {
		model.put("errorMessage", "Invalid Credentials");
		return "login";
	}
	model.put("name1",name);
			return "welcome"; 
}

@RequestMapping(value="/register", method= RequestMethod.GET) 	
public String doregistration() {
		return "register"; 
	}

@RequestMapping(value="/register", method= RequestMethod.POST) 
public String registeration(@RequestParam String username, @RequestParam String password, ModelMap model1) {

	model1.put("name",username);
		return "successfulregistration"; 

}
	
}