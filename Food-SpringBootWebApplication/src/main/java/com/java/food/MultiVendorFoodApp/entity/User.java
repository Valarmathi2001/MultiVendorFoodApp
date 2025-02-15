package com.java.food.MultiVendorFoodApp.entity;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "User_Table")
@Data
@ToString(exclude = {"user", "orders", "cartItems"})
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "User_ID")
	private Long userId;
	
	@Size(min = 2, max = 50)
	@NotNull(message = "User Name cannot be Empty!!")
	@Column(name = "User_Name")
	private String userName;

	@Email
	@NotNull(message = "Email ID cannot be Empty!!")
	@Column(name = "Email", unique = true)
	private String emailId;
	
	@NotNull
	@Size(min =8, message = "Password must be more than 8 digits")
	@NotNull(message = "Password cannot be Empty!!")
	@Column(name = "Password")
	private String password;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Order> orders;
	
	@Size(min=10, max= 10, message = "Mobile umber must be 10 digits!!")
	@NotNull(message = "Mobile Number cannot be Empty!!")
	@Column(name = "MobileNumber")
	private String mobileNumber;
	
	
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	@JoinColumn(name = "Cart_id")
	private Cart cart;
	
	@Override
	public String toString() {
	    return "User{" +
	           "id=" + userId +
	         
	           '}'; // Exclude `orders` or `cart`
	}

	

}
