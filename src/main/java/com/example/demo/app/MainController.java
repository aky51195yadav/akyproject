package com.example.demo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@Autowired
	LoginService logservice;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "LoginPage";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password) {
		boolean service = logservice.userValidation(name, password);

		if (!service) {
			model.put("errormessage", "You have entered wrong details");
			return "LoginPage";
		}
		return "WelcomePage";
	}
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	@ResponseBody
	public String showData() {
		return "LoginPage";
	}
}
