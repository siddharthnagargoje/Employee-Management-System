package com.qsp.employee_management_system.exception;

public class IncorrectPasswordException extends RuntimeException{

	private String message;

	public IncorrectPasswordException(String message) 
	{
		super();
		this.message = message;
	}
	
	public String getMessage()
	{
		return message;	
	}

}
