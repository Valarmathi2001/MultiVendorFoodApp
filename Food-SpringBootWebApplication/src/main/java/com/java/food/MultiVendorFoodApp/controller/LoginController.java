package com.java.food.MultiVendorFoodApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.food.MultiVendorFoodApp.service.LoginService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("MultiVendorFoodAPP")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@GetMapping("loginUser")
	public String loginUser(@Valid @RequestBody String email, String passWord) {
		loginService.loginUser(email, passWord);
		return "Success";
		
	}
	
	@GetMapping("loginVendor")
	public String loginVendor(@Valid @RequestBody String email, String password, String shopName) {
		return loginService.loginVendor( email, password, shopName );
		
	}
	
	
	

}
