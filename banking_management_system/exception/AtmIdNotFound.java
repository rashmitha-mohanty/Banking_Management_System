package com.qsp.banking_management_system.exception;

public class AtmIdNotFound extends RuntimeException{
	private String message="Atm is not present in DB";

	public String getMessage() {
		return message;
	}
}
