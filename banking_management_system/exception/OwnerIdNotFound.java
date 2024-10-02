package com.qsp.banking_management_system.exception;

public class OwnerIdNotFound extends RuntimeException{

	private String message="Owner is not present in DB";

	public String getMessage() {
		return message;
	}
	
	
}
