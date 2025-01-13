package com.java.food.MultiVendorFoodApp.service;

import com.java.food.MultiVendorFoodApp.DTO.UserDTO;
import com.java.food.MultiVendorFoodApp.DTO.VendorDTO;
import com.java.food.MultiVendorFoodApp.entity.User;
import com.java.food.MultiVendorFoodApp.entity.Vendor;

public interface RegisterService {

	String registerUser(UserDTO userDTO);
	String registerVendor(VendorDTO vendorDTO);
}
