package com.java.food.MultiVendorFoodApp.DTO;

import java.util.List;

import com.java.food.MultiVendorFoodApp.entity.Food;
import com.java.food.MultiVendorFoodApp.entity.Shop;
import com.java.food.MultiVendorFoodApp.entity.Vendor;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShopDTO {
	private String shopName;
	private Vendor vendor;
	private List<Food> foodItems;

	public ShopDTO(String shopName) {
		super();
		this.shopName = shopName;
	}
	
	

}
