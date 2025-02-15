package com.java.food.MultiVendorFoodApp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.food.MultiVendorFoodApp.service.ShowService;

import ch.qos.logback.core.joran.sanity.Pair;

@RestController
@RequestMapping("MultiVendorFoodAPP")
public class ShowController {
	
	@Autowired
	ShowService showService;

	@GetMapping("Show/Cart")
	public org.springframework.data.util.Pair<Integer, Map<String, List<Integer>>> showCart(String userName){
		return showService.showCart(userName);
		
	}
}
