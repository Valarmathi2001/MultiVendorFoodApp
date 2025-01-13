package com.java.food.MultiVendorFoodApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.food.MultiVendorFoodApp.entity.User;
import com.java.food.MultiVendorFoodApp.entity.Vendor;
import com.java.food.MultiVendorFoodApp.exception.PasswordIsWrongException;
import com.java.food.MultiVendorFoodApp.exception.ThereIsNoUserException;
import com.java.food.MultiVendorFoodApp.repository.ShopRepository;
import com.java.food.MultiVendorFoodApp.repository.UserRepository;
import com.java.food.MultiVendorFoodApp.repository.VendorRepository;

@Service
public class LognServiceImpl implements LoginService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ShopRepository shopRepository;
	
	@Autowired
	VendorRepository vendorRepository;
	
	
	@Override
	public String loginUser(String emailId, String passWord) {
		Optional<User> user = userRepository.findByEmailIdAndPassword(emailId,passWord);
		if(user.isPresent()) {
			return "User logged in Successfully";
		}
		Optional<User> mailId = userRepository.findByEmailId(emailId);
		if(mailId.isPresent()) {
			throw new PasswordIsWrongException("Your Password is wrong!!");
		}
		throw new ThereIsNoUserException("You are not registered yet!!");
		
		
	}


	@Override
	public String loginVendor(String email, String passWord, String shopName) {
		Long isVendorExist = shopRepository.countByShopnameAndVendor_EmailAndVendor_Password(shopName,email,passWord);
		if(isVendorExist>0) {
			return "Vendor Logged in Successfully";
		}
		Optional<Vendor> mailId = vendorRepository.findByEmail(email);
		if(mailId.isPresent()) {
			throw new PasswordIsWrongException("There is no shop with this shop name!");
		}
		throw new ThereIsNoUserException("There is no Vendor with this email ID!!");
		
	}


	
	

}
