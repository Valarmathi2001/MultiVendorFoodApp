package com.java.food.MultiVendorFoodApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.food.MultiVendorFoodApp.DTO.UserConverter;
import com.java.food.MultiVendorFoodApp.DTO.UserDTO;
import com.java.food.MultiVendorFoodApp.DTO.VendorConverter;
import com.java.food.MultiVendorFoodApp.DTO.VendorDTO;
import com.java.food.MultiVendorFoodApp.entity.User;
import com.java.food.MultiVendorFoodApp.entity.Vendor;
import com.java.food.MultiVendorFoodApp.repository.UserRepository;
import com.java.food.MultiVendorFoodApp.repository.VendorRepository;

@Service
public class RegisterServiceImpl implements RegisterService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	VendorRepository vendorRepository;

	@Override
	public String registerUser(UserDTO userDTO) {
		User user = UserConverter.toEntity(userDTO);
		userRepository.save(user);
		return "User Registered Successfully";
	} 

	@Override
	public String registerVendor(VendorDTO vendorDTO) {
		Vendor vendor = VendorConverter.toEntity(vendorDTO);
		vendor.addShops(vendor.getShops());
		vendorRepository.save(vendor);
		return "Vendor Registered Successfully";
		}

	
	
	
}
