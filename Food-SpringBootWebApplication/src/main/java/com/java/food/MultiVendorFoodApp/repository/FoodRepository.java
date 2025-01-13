package com.java.food.MultiVendorFoodApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.food.MultiVendorFoodApp.DTO.FoodDTO;
import com.java.food.MultiVendorFoodApp.entity.Food;

public interface FoodRepository extends JpaRepository<Food,Long>{
	
	@Query(value = "SELECT f.name,f.price,f.description FROM food_table f JOIN shop s ON s.shop_id = f.shop_shop_id WHERE s.shop_name = :shopName AND LOWER(f.name) LIKE LOWER(CONCAT('%', :foodName, '%'))", nativeQuery = true)
	List<FoodDTO> findByNameIgnoreCaseContaining(String foodName, String shopName); 

	List<Food> findAllByName(String foodName);
}
