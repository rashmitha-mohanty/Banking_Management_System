package com.qsp.banking_management_system.exception;

public class AddressIdNotFound extends RuntimeException{
	private String message="Address is not present in DB";

	public String getMessage() {
		return message;
	}
}
