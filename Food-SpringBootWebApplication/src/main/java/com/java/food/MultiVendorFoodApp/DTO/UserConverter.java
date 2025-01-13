package com.java.food.MultiVendorFoodApp.DTO;

import com.java.food.MultiVendorFoodApp.entity.User;

public class UserConverter {
	
	 public static UserDTO toDTO(User user) {
		 return new UserDTO(user.getUserName(),user.getEmailId(),user.getPassword(), user.getMobileNumber());
	 }

	    // Convert DTO to Entity
	    public static User toEntity(UserDTO userDTO) {
	        User user = new User();
	        user.setUserName(userDTO.getUserName());
	        user.setEmailId(userDTO.getEmailId());
	        user.setPassword(userDTO.getPassword());
	        user.setMobileNumber(userDTO.getMobileNumber());
	        return user;
	    }

}
