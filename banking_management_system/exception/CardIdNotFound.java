package com.qsp.banking_management_system.exception;

public class CardIdNotFound extends RuntimeException{
	private String message="Card is not present in DB";

	public String getMessage() {
		return message;
	}
}
