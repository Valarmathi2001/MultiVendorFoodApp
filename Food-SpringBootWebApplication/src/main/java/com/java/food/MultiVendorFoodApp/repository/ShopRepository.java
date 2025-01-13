package com.java.food.MultiVendorFoodApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.food.MultiVendorFoodApp.entity.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop,Integer>{
	
	@Query(value = "SELECT COUNT(s.shop_id) FROM shop s JOIN vendor_table v ON s.vendor_vendor_id = v.vendor_id WHERE s.shop_name = :shopName AND v.email = :email AND v.password = :password", nativeQuery = true)
	Long countByShopnameAndVendor_EmailAndVendor_Password(@Param("shopName") String shopName,@Param("email") String email, @Param("password") String password);
	
	@Query(value = "Select * from Shop where lower(shop_name) like lower(concat('%',:shopName, '%'))", nativeQuery = true)
	List<Shop> findAllByShopName(String shopName);
	
	Optional<Shop> findByShopName(String shopName);
	
	

}
