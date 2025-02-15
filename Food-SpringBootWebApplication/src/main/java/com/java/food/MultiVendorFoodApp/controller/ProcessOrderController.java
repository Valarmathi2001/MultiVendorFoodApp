package com.java.food.MultiVendorFoodApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.food.MultiVendorFoodApp.service.ProcessOrderService;

@RestController
@RequestMapping("MultiVendorFoodAPP")
public class ProcessOrderController {
	
	@Autowired
	ProcessOrderService processOrderService;
	
	@PostMapping("Place/Order")
	public String PlaceOrder(String userName) {
		return "Your Order Placed Successfully!! Your Order ID - " + processOrderService.PlaceOrder(userName);
	}
	
	@PutMapping("Deliver/Order")
	public String DeliverOrder(String userName, Long orderID) {
		processOrderService.DeliverOrder(userName, orderID);
		return "Your Order Number - "+ orderID.toString() + " is Delivered" ;
		
	}
}
