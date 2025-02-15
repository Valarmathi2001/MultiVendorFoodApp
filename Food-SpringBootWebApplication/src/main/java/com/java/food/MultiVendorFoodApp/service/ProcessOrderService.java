package com.java.food.MultiVendorFoodApp.service;


public interface ProcessOrderService {
	String PlaceOrder(String UserName);
	void DeliverOrder(String userName, Long OrderID);
}
