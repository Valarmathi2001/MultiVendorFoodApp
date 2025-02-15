package com.java.food.MultiVendorFoodApp.repository;

import java.util.Optional;

import org.hibernate.usertype.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.food.MultiVendorFoodApp.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	Optional<User> findByEmailIdAndPassword(String emailId, String password);
	Optional<User> findByEmailId(String emailId);
	Optional<User> findByUserName(String name);
	

}
