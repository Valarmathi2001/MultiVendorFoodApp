package com.java.food.MultiVendorFoodApp.exception;

import org.apache.logging.log4j.message.Message;

public class PasswordIsWrongException extends RuntimeException{
	
	public PasswordIsWrongException(String message) {
		super(message);
	}

}
