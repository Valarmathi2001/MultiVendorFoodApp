package com.java.food.MultiVendorFoodApp.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import com.java.food.MultiVendorFoodApp.Projection.FoodProjection;
import com.java.food.MultiVendorFoodApp.entity.Cart;
import com.java.food.MultiVendorFoodApp.entity.Food;
import com.java.food.MultiVendorFoodApp.entity.User;
import com.java.food.MultiVendorFoodApp.exception.ThereIsNoUserException;
import com.java.food.MultiVendorFoodApp.repository.UserRepository;



@Service
public class ShowServiceImpl implements ShowService {
	
	@Autowired
	UserRepository userRepository;
	
	public Pair<Integer,Map<String,List<Integer>>> showCart(String userName){
		User user = userRepository.findByUserName(userName).orElseThrow(()-> new ThereIsNoUserException("There is no user with this name"));
		Cart cart =user.getCart();
		
		System.out.println("User object: " + user); // Check if this causes the issue
		//Cart cart = user.getCart();
		System.out.println("Cart object: " + cart); // Check if this causes the issue
		System.out.println("Cart items: " + cart.getCartItems()); // Check the items
		System.out.println(cart);
		Map<String,List<Integer>> map1 = new HashMap<String,List<Integer>>();
		cart.getCartItems().stream().forEach(cartItem -> map1.put(cartItem.getFood().getName()
				,Arrays.asList(cartItem.getFood().getPrice()
						,cartItem.getQuantity()
						,cartItem.getFood().getPrice()*cartItem.getQuantity())));
		Integer sum = map1.values().stream().mapToInt(list -> list.get(2)).sum();
		Pair<Integer,Map<String,List<Integer>>> pair = Pair.of(sum, map1);
		return pair;

		
	}

}
