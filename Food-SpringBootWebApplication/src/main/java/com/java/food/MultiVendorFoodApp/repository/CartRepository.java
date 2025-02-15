package com.java.food.MultiVendorFoodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.food.MultiVendorFoodApp.entity.Cart;
import com.java.food.MultiVendorFoodApp.entity.Food;

public interface CartRepository extends JpaRepository<Cart,Long>{

	

}
