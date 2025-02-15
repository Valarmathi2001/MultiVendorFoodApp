package com.java.food.MultiVendorFoodApp.DTO;

import java.util.ArrayList;
import java.util.List;

import com.java.food.MultiVendorFoodApp.entity.Shop;

public class ShopConvertor {

	public static List<Shop> convertToEntitys(List<ShopDTO> list) {
		List<Shop> shopList = new ArrayList();
		for(ShopDTO shopDto : list){
			 shopList.add(new Shop(shopDto.getShopName()));
		}
		
		return shopList;
	}
	
	public static List<ShopDTO> converToDTOs(List<Shop> list){
		List<ShopDTO> shopDTOList = new ArrayList();
		for(Shop shop : list) {
			shopDTOList.add(new ShopDTO(shop.getShopName()));
		}
		return shopDTOList;
	}
	

}

	
