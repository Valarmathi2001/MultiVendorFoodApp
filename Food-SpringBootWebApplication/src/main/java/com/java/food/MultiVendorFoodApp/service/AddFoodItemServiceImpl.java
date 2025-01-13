package com.java.food.MultiVendorFoodApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.food.MultiVendorFoodApp.entity.Food;
import com.java.food.MultiVendorFoodApp.entity.Shop;
import com.java.food.MultiVendorFoodApp.exception.SerachNotFoundException;
import com.java.food.MultiVendorFoodApp.repository.FoodRepository;
import com.java.food.MultiVendorFoodApp.repository.ShopRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AddFoodItemServiceImpl implements AddFoodItemService {
	
	@Autowired
	ShopRepository shopRepository;
	
	@Autowired
	FoodRepository foodRepository;

	@Override
	public String addFoodToShop(String foodName, int price, String Description, String shopName) {
		// TODO Auto-generated method stub
		Food food = new Food();
		food.setName(foodName);
		food.setPrice(price);
		
		food.setShop(shopRepository.findByShopName(shopName)
				.orElseThrow(()-> new SerachNotFoundException(shopName+" Not Found")));
		food.setDescription(Description);
		foodRepository.save(food);
		return "Food Item Added Successfully";
	}
	
	
	
	

}
