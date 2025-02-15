package com.java.food.MultiVendorFoodApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.food.MultiVendorFoodApp.DTO.FoodDTO;
import com.java.food.MultiVendorFoodApp.Projection.FoodProjection;
import com.java.food.MultiVendorFoodApp.entity.Food;

public interface FoodRepository extends JpaRepository<Food,Long>{
	
	@Query(value = "SELECT f.name,f.price,f.description,s.shop_name FROM food_table f JOIN shop s ON s.shop_id = f.shop_shop_id WHERE LOWER(s.shop_name) LIKE LOWER(CONCAT('%', :shopName, '%')) AND LOWER(f.name) LIKE LOWER(CONCAT('%', :foodName, '%'))", nativeQuery = true)
	List<FoodProjection> findByNameIgnoreCaseContaining(String foodName, String shopName); 

	@Query(value = "SELECT f.name,f.price,f.description,s.shop_name FROM food_table f JOIN shop s ON s.shop_id = f.shop_shop_id WHERE LOWER(f.name) LIKE LOWER(CONCAT('%', :foodName, '%'))", nativeQuery = true)
	List<FoodProjection> findAllByName(String foodName);
	
	@Query(value = "Select f.name,f.price,f.description from food_table f where f.food_id = :id", nativeQuery = true)
	FoodProjection findFoodById(Long id);
	
	@Query(value = "SELECT f.food_id,f.name,f.price,f.description,f.order_order_id,f.cart_cart_id,f.shop_shop_id FROM food_table f JOIN shop s ON s.shop_id = f.shop_shop_id WHERE LOWER(s.shop_name) LIKE LOWER(CONCAT('%', :shopName, '%')) AND LOWER(f.name) LIKE LOWER(CONCAT('%', :foodName, '%'))", nativeQuery = true)
	Optional<Food> findByNameAndShopName(String foodName, String shopName);
}
