package com.example.demo.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping(value = "register")
public class RegisterController {
	
	@RequestMapping(value = "form", method = RequestMethod.GET)
	public String showRegisterPage()
	{
		return "RegisterPage";
	}
	
	
	
}
