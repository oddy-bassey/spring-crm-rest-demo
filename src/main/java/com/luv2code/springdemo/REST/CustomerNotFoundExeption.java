package com.luv2code.springdemo.REST;

public class CustomerNotFoundExeption extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerNotFoundExeption() { 
	}

	public CustomerNotFoundExeption(String message) {
		super(message); 
	}

	public CustomerNotFoundExeption(Throwable cause) {
		super(cause); 
	}

	public CustomerNotFoundExeption(String message, Throwable cause) {
		super(message, cause); 
	}

	public CustomerNotFoundExeption(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace); 
	}

}
