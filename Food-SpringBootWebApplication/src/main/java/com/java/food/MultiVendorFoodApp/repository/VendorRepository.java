package com.java.food.MultiVendorFoodApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.food.MultiVendorFoodApp.entity.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor,Long> {
	
   Optional<Vendor> findByEmail(String email);

}
