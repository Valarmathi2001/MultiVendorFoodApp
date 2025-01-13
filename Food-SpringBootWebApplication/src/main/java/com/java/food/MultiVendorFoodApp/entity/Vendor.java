package com.java.food.MultiVendorFoodApp.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.java.food.MultiVendorFoodApp.DTO.ShopDTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "Vendor_Table")
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "vendorId")

public class Vendor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Vendor_Id")
	private Long vendorId;
	
	@NotEmpty(message = "Vendor Name cannot be Empty!!")
	@Column(name = "Vendor_Name")
	private String vendorName;
	
	@NotEmpty(message = "Shop Name cannot be Empty!!")
	@OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Shop> shops;
	
	@Email
	@NotEmpty(message = "Email cannot be Empty!!")
	@Column(name = "Email")
	private String email;
	
	@NotNull
	@Size(min =8, message = "Password must be more than 8 digits")
	@NotNull(message = "Password cannot be Empty!!")
	@Column(name = "Password")
	private String password;
	
	@Size(min=10, max= 10, message = "Mobile umber must be 10 digits!!")
	@NotNull(message = "Mobile Number cannot be Empty!!")
	@Column(name = "MobileNumber")
	private String mobileNumber;
	
	public void addShops(List<Shop> shopsList) {
		for(Shop shop : shopsList){
			shop.setVendor(this);
		}
		this.shops.addAll(shopsList);
		
	}
	

}
