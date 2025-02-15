package com.java.food.MultiVendorFoodApp.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.food.MultiVendorFoodApp.entity.Cart;
import com.java.food.MultiVendorFoodApp.entity.CartItems;
import com.java.food.MultiVendorFoodApp.entity.Food;
import com.java.food.MultiVendorFoodApp.entity.Shop;
import com.java.food.MultiVendorFoodApp.entity.User;
import com.java.food.MultiVendorFoodApp.exception.SerachNotFoundException;
import com.java.food.MultiVendorFoodApp.exception.ThereIsNoUserException;
import com.java.food.MultiVendorFoodApp.repository.CartRepository;
import com.java.food.MultiVendorFoodApp.repository.FoodRepository;
import com.java.food.MultiVendorFoodApp.repository.ShopRepository;
import com.java.food.MultiVendorFoodApp.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AddFoodItemServiceImpl implements AddFoodItemService {
	
	@Autowired
	ShopRepository shopRepository;
	
	@Autowired
	FoodRepository foodRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	UserRepository userRepository;

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
	
	
	public String addFoodToCart(String foodName,String shopName, String userName,int quantity) {
		Food food = foodRepository.findByNameAndShopName(foodName, shopName).orElseThrow(() -> new SerachNotFoundException("No food iteam match with your search"));
		User user = userRepository.findByUserName(userName).orElseThrow(() -> new ThereIsNoUserException("No User registered with this name"));
		CartItems cartItem = new CartItems(food,quantity);
		 Cart cart;
		    if (user.getCart() != null) {
		        // Use the existing cart
		        cart = user.getCart();
		    } else {
		        // Create a new cart
		        cart = new Cart();
		        cart.setUser(user);  // Set the user for the cart
		    }

		    // Add cartItem to the cart and set the reference
		    cartItem.setCart(cart);  // VERY IMPORTANT: Set the cart reference in CartItems
		    cart.getCartItems().add(cartItem);

		    // Save cart (Cascades to CartItems)
		    cartRepository.save(cart);

		    return "Item Added to Cart";
	}
	

}
