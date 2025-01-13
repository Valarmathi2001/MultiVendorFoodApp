package com.java.food.MultiVendorFoodApp.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.food.MultiVendorFoodApp.DTO.FoodDTO;
import com.java.food.MultiVendorFoodApp.DTO.ShopConvertor;
import com.java.food.MultiVendorFoodApp.DTO.ShopDTO;
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
	
	public Optional<Food> searchFoodByID(Long id) {
		return foodRepository.findById(id);
	}
	
	public List<Food> searchFoodByName(String foodName, String shopName) {
		return foodRepository.findByNameIgnoreCaseContaining(foodName,shopName);
	}
	
	public ShopDTO searchShopByID(Integer id) {
		Optional<Shop> shop = shopRepository.findById(id);
		return (ShopDTO) ShopConvertor.converToDTO(Collections.singletonList(shop.orElseThrow(()-> new SerachNotFoundException("Search Not found"))));
	}
	
	public List<ShopDTO> searchShopByName(String shopName) {
		List<Shop> shops = shopRepository.findAllByShopName(shopName);
		return ShopConvertor.converToDTO(shops);
		
		
	}
	
	public List<FoodDTO> searchFoodByNameWithShopName(String foodName, String shopName){
		return foodRepository.findByNameIgnoreCaseContaining(foodName,shopName);
		
	}
	
	
	
	
	

}
