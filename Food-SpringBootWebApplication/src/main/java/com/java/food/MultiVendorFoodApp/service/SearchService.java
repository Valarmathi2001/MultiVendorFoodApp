package com.java.food.MultiVendorFoodApp.service;

import java.util.List;
import java.util.Optional;

import com.java.food.MultiVendorFoodApp.DTO.FoodDTO;
import com.java.food.MultiVendorFoodApp.DTO.ShopDTO;
import com.java.food.MultiVendorFoodApp.Projection.FoodProjection;
import com.java.food.MultiVendorFoodApp.Projection.ShopProjection;
import com.java.food.MultiVendorFoodApp.entity.Food;
import com.java.food.MultiVendorFoodApp.entity.Shop;

public interface SearchService {
	
	FoodProjection searchFoodByID(Long id);
	List<FoodProjection> searchFoodByName(String FoodName);
	ShopProjection searchShopByID(Integer id);
	List<ShopProjection> searchShopByName(String shopName);
	
	List<FoodProjection> searchFoodByNameWithShopName(String foodName, String shopName);

}
