package com.java.food.MultiVendorFoodApp.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.java.food.MultiVendorFoodApp.DTO.ShopDTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "shopId")

public class Shop {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "Shop_Id")
	private Integer shopId;
	
	@NotEmpty(message = "Shop name cannot be Empty!!")
	@Column(name = "ShopName")
	private String shopName;
	
	@OneToMany(mappedBy = "shop")
	private List<Food> foodItems;
	
	@ManyToOne
	private Vendor vendor;
	


	public Shop(@NotEmpty(message = "Shop name cannot be Empty!!") String shopName) {
		super();
		this.shopName = shopName;
	}
	
	

}
