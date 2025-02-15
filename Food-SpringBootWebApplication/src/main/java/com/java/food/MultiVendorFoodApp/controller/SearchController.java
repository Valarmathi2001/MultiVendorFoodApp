package com.java.food.MultiVendorFoodApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.food.MultiVendorFoodApp.DTO.FoodDTO;
import com.java.food.MultiVendorFoodApp.DTO.ShopDTO;
import com.java.food.MultiVendorFoodApp.Projection.FoodProjection;
import com.java.food.MultiVendorFoodApp.Projection.ShopProjection;
import com.java.food.MultiVendorFoodApp.entity.Food;
import com.java.food.MultiVendorFoodApp.entity.Shop;
import com.java.food.MultiVendorFoodApp.service.SearchService;

@RestController
@RequestMapping("MultiVendorFoodApp")
public class SearchController {
	
	@Autowired
	SearchService searchService;
	
	@GetMapping("search/Food/Id")
	public FoodProjection searchFoodByID(Long id) {
		return searchService.searchFoodByID(id);
	}
	
	@GetMapping("search/{shopName}/Food/Name")
	public List<FoodProjection> searchFoodByName(String foodName, @PathVariable String shopName) {
		return searchService.searchFoodByNameWithShopName(foodName, shopName);
	}
	
	@GetMapping("search/Food/Name")
	public List<FoodProjection> searchFoodByNameInAllShop(String foodName) {
		return searchService.searchFoodByName(foodName);
	}
	
	
	@GetMapping("search/Shop/Id")
	public ShopProjection searchShopByID(Integer id) {
		return searchService.searchShopByID(id);
	}
	
	@GetMapping("search/Shop/Name")
	public List<ShopProjection> searchShopByName(String shopName) {
		return searchService.searchShopByName(shopName);
	}


}
