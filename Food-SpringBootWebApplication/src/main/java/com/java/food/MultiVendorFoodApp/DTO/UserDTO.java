package com.java.food.MultiVendorFoodApp.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {
	private String userName;
    private String emailId;
    private String password;
    private String mobileNumber;

}
