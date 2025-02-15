package com.java.food.MultiVendorFoodApp.service;

public interface AddFoodItemService {
	
	String addFoodToShop(String foodName,int price,String Description,String shopName);
	String addFoodToCart(String foodName,String shopName,String userName,int quantity);

}
