package com.java.food.MultiVendorFoodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.food.MultiVendorFoodApp.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{
	
}
