package com.java.food.MultiVendorFoodApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.food.MultiVendorFoodApp.service.AddFoodItemService;

@RestController
@RequestMapping("MultiVendorFoodAPP")
public class AddFoodItemController {
	
	@Autowired
	AddFoodItemService addFoodItemService;
	
	@PostMapping("Add/Food/Shop")
	public String addFoodToShop(String foodName, int price, String Description, String shopName) {
		return addFoodItemService.addFoodToShop(foodName,price,Description,shopName);
	}
	
	@PostMapping("Add/Food/Cart")
	public String addFoodToCart(String foodName,String shopName, String userName,int quantity) {
		return addFoodItemService.addFoodToCart(foodName, shopName,  userName, quantity);
	}

}
