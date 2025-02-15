package com.java.food.MultiVendorFoodApp.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.food.MultiVendorFoodApp.DTO.FoodDTO;
import com.java.food.MultiVendorFoodApp.DTO.ShopConvertor;
import com.java.food.MultiVendorFoodApp.DTO.ShopDTO;
import com.java.food.MultiVendorFoodApp.Projection.FoodProjection;
import com.java.food.MultiVendorFoodApp.Projection.ShopProjection;
import com.java.food.MultiVendorFoodApp.entity.Food;
import com.java.food.MultiVendorFoodApp.entity.Shop;
import com.java.food.MultiVendorFoodApp.exception.SerachNotFoundException;
import com.java.food.MultiVendorFoodApp.repository.FoodRepository;
import com.java.food.MultiVendorFoodApp.repository.ShopRepository;

@Service
public class SearchServiceImpl implements SearchService {
	
	@Autowired
	FoodRepository foodRepository;
	
	@Autowired
	ShopRepository shopRepository;
	
	public FoodProjection searchFoodByID(Long id) {
		return foodRepository.findFoodById(id);
	}
	
	public List<FoodProjection> searchFoodByNameWithShopName(String foodName, String shopName) {
		return foodRepository.findByNameIgnoreCaseContaining(foodName,shopName);
	}
	
	public ShopProjection searchShopByID(Integer id) {
		ShopProjection shop = shopRepository.findShopById(id);
		return shop;
	}
	
	public List<ShopProjection> searchShopByName(String shopName) {
		List<ShopProjection> shops = shopRepository.findAllByShopName(shopName);
		return shops;
		
		
	}
	
	public List<FoodProjection> searchFoodByName(String foodName){
		return foodRepository.findAllByName(foodName);
		
	}
	
	

	
	
	
	
	
	

}
