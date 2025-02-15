package com.java.food.MultiVendorFoodApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class CartItems {
	
	public CartItems() {
		super();
	}


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
    
  
	public CartItems(Food food, int quantity) {
		super();
		this.food = food;
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
	    return "User{" +
	           "id=" + id +
	           
	           '}'; // Exclude `orders` or `cart`
	}


}
