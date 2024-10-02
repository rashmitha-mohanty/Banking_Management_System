package com.qsp.banking_management_system.exception;

public class BankIdNotFound extends RuntimeException{
	private String message="Bank is not present in DB";

	public String getMessage() {
		return message;
	}
}
