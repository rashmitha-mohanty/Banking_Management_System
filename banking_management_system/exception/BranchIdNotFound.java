package com.qsp.banking_management_system.exception;

public class BranchIdNotFound extends RuntimeException{
	private String message="Branch is not present in DB";

	public String getMessage() {
		return message;
	}
}
