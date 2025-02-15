package com.java.food.MultiVendorFoodApp.entity;

import java.util.List;
import java.util.Map;

import com.java.food.MultiVendorFoodApp.Enum.OrderStatus;

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
	private Long orderId;
	
	@NotNull(message = "Price cannot be Empty!!")
	@Column(name = "TotalAmount")
	private int totalAmount;
	
	
	
	@NotNull(message = "Status cannot be Empty!!")
	@Column(name = "Status")
	private OrderStatus status;
	
	
	
	
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<OrderItems> orderItems;
	
	@Override
	public String toString() {
	    return "Order{" +
	           "id=" + orderId +
	          
	           '}'; // Exclude `user`
	}
	
	


}
