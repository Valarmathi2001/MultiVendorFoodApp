package com.java.food.MultiVendorFoodApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.java.food.MultiVendorFoodApp.DTO.UserDTO;
import com.java.food.MultiVendorFoodApp.DTO.VendorDTO;

import com.java.food.MultiVendorFoodApp.service.RegisterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("MultiVendorFoodAPP")
public class RegisterController {

	@Autowired
	RegisterService registerService;

	@PostMapping("registerUser")
	public String register(@Valid @RequestBody UserDTO userDTO) {
		return registerService.registerUser(userDTO);
	}
	
	@PostMapping("registerVendor")
	public String registerVendor(@Valid @RequestBody VendorDTO vendorDTO) {
		return registerService.registerVendor(vendorDTO);
		
	}

}
