package com.java.food.MultiVendorFoodApp.DTO;

import java.util.List;

import com.java.food.MultiVendorFoodApp.entity.Shop;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VendorDTO {
	private String vendorName;
    private String emailId;
    private String password;
    private String mobileNumber;
    private List<ShopDTO> shopDTO;


}
