package com.java.food.MultiVendorFoodApp.DTO;

import java.util.List;
import java.util.stream.Collectors;

import com.java.food.MultiVendorFoodApp.entity.Shop;
import com.java.food.MultiVendorFoodApp.entity.Vendor;

public class VendorConverter {
	
	public static Vendor toEntity(VendorDTO vendorDTO) {
		Vendor vendor = new Vendor();
		vendor.setVendorName(vendorDTO.getVendorName());
		vendor.setEmail(vendorDTO.getEmailId());
		vendor.setShops(ShopConvertor.convertToEntitys(vendorDTO.getShopDTO()));
		vendor.setMobileNumber(vendorDTO.getMobileNumber());
		vendor.setPassword(vendorDTO.getPassword());
		return vendor;
	}
	
	public static VendorDTO toDTO(Vendor vendor)
	{
		return new VendorDTO(vendor.getVendorName(),vendor.getEmail(),vendor.getPassword(),vendor.getMobileNumber(),ShopConvertor.converToDTOs(vendor.getShops()));
	}
}
