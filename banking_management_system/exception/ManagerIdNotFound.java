package com.qsp.banking_management_system.exception;

public class ManagerIdNotFound extends RuntimeException{
	
	private String message="Manager is not present in DB";

	public String getMessage() {
		return message;
	}
}
