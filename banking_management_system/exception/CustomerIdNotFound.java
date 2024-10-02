package com.qsp.banking_management_system.exception;

public class CustomerIdNotFound extends RuntimeException{
	private String message="Customer is not present in DB";

	public String getMessage() {
		return message;
	}
}
