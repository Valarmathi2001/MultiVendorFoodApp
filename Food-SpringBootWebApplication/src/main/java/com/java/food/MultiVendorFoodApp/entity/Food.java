package com.java.food.MultiVendorFoodApp.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;



@Entity
@Table(name = "Food_Table")
@Data
public class Food {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long foodId;
	
	@NotEmpty(message = "Food Name cannot be Empty!!")
	private String name;
	
	@NotNull
	private int price;
	
	@NotNull(message = "Shop cannot be Empty!!")
	@ManyToOne
	private Shop shop;
	
	private String Description;
	

	
}
