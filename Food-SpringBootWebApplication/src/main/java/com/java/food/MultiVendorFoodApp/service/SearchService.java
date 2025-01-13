package com.java.food.MultiVendorFoodApp.service;

import java.util.List;
import java.util.Optional;

import com.java.food.MultiVendorFoodApp.DTO.ShopDTO;
import com.java.food.MultiVendorFoodApp.entity.Food;
import com.java.food.MultiVendorFoodApp.entity.Shop;

public interface SearchService {
	
	Optional<Food> searchFoodByID(Long id);
	List<Food> searchFoodByName(String FoodName,String shopName);
	ShopDTO searchShopByID(Integer id);
	List<ShopDTO> searchShopByName(String shopName);
	List<Food> searchFoodByName();
	List<Food> searchFoodByNameWithShopName(String foodName, String shopName);

}
