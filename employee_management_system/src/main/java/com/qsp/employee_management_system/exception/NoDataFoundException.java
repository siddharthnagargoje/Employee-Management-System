package com.qsp.employee_management_system.exception;

public class NoDataFoundException extends RuntimeException
{
	private String message;

	public NoDataFoundException(String message) 
	{
		super();
		this.message = message;
	}
	public String getMessage()
	{
		return message;	
	}

	

}
