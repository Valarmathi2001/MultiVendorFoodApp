package com.java.food.MultiVendorFoodApp.service;

import java.util.List;
import java.util.Map;

import com.java.food.MultiVendorFoodApp.Projection.FoodProjection;
import com.java.food.MultiVendorFoodApp.entity.Food;

import ch.qos.logback.core.joran.sanity.Pair;

public interface ShowService {
	org.springframework.data.util.Pair<Integer, Map<String, List<Integer>>> showCart(String UserName);
}
