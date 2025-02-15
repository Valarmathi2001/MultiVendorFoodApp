package com.java.food.MultiVendorFoodApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class OrderItems {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	 @ManyToOne
	 @JoinColumn(name = "food_id")
	 private Food food;

	 private int quantity;

	 @ManyToOne
	 @JoinColumn(name = "order_id")
	 private Order order;
}
