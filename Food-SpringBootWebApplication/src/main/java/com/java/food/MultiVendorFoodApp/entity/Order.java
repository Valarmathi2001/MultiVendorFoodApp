package com.java.food.MultiVendorFoodApp.entity;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Data
@Table(name = "Order_Table")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Order_Id")
	@NotNull(message = "Order ID cannot be Empty!!")
	private Long orderId;
	
	@NotNull(message = "Price cannot be Empty!!")
	@Column(name = "Price")
	private int price;
	
	@NotNull(message = "Quantity cannot be Empty!!")
	@Column(name = "Quantity")
	private int quantity;
	
	@NotNull(message = "Status cannot be Empty!!")
	@Column(name = "Status")
	private String status;
	
	
	
	@NotNull(message = "User cannot be Empty!!")
	@ManyToOne
	private User user;
	
	@NotNull(message = "Food cannot be Empty!!")
	@OneToMany(mappedBy = "order")
	private List<Food> food;
	

}
