package com.java.food.MultiVendorFoodApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.food.MultiVendorFoodApp.Enum.OrderStatus;
import com.java.food.MultiVendorFoodApp.entity.Cart;
import com.java.food.MultiVendorFoodApp.entity.CartItems;
import com.java.food.MultiVendorFoodApp.entity.Order;
import com.java.food.MultiVendorFoodApp.entity.OrderItems;
import com.java.food.MultiVendorFoodApp.entity.User;
import com.java.food.MultiVendorFoodApp.exception.SerachNotFoundException;
import com.java.food.MultiVendorFoodApp.exception.ThereIsNoUserException;
import com.java.food.MultiVendorFoodApp.repository.OrderRepository;
import com.java.food.MultiVendorFoodApp.repository.UserRepository;

@Service
public class ProcessOrderServiceImpl implements ProcessOrderService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public String PlaceOrder(String userName) {
		User user = userRepository.findByUserName(userName).orElseThrow(()-> new ThereIsNoUserException("There is no user with this name"));
		Cart cart =user.getCart();
		if(cart==null) {
			throw new SerachNotFoundException("Your Cart is Empty");
		}
		Order order = new Order();
		List<CartItems> cartItems = cart.getCartItems(); // Assuming cartItems is of type CartItem
		List<OrderItems> orderItems = new ArrayList<>();

		// Convert CartItem to OrderItems
		for (CartItems cartItem : cartItems) {
		    OrderItems orderItem = new OrderItems();
		    orderItem.setFood(cartItem.getFood());
		    orderItem.setQuantity(cartItem.getQuantity());
		    orderItems.add(orderItem);
		}
		//OrderItems orderItems = new OrderItems(food,quantity);
		order.setOrderItems(orderItems);
		int sum = cart.getCartItems().stream().mapToInt(cartItem -> cartItem.getFood().getPrice()*cartItem.getQuantity()).sum();
		order.setTotalAmount(sum);
		order.setStatus(OrderStatus.Pending);
		order.setUser(user);
		orderRepository.save(order);
		return order.getOrderId().toString();
	}

	@Override
	public void DeliverOrder(String userName, Long orderId) {
		Order order = orderRepository.findById(orderId).orElseThrow(() -> new SerachNotFoundException("No search found with this OrderID!"));
		order.setStatus(OrderStatus.Delivered);
		orderRepository.save(order);
		
	}
	
	

}
