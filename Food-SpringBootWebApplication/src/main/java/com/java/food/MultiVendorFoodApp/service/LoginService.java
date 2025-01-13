package com.java.food.MultiVendorFoodApp.service;



public interface LoginService {


	String loginUser(String email, String passWord);
	String loginVendor(String email, String passWord,String Shopname);

}
