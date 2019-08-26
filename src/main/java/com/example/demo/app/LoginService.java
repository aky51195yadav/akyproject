package com.example.demo.app;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    
	public boolean userValidation(String username, String password) {
		System.out.println(username + " : " + password);
		return username.equalsIgnoreCase("Ankit") && password.equals("Akyadav");
	}

}
