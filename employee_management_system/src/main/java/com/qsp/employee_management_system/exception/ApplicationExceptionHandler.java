package com.qsp.employee_management_system.exception;

import java.sql.Struct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.qsp.employee_management_system.util.ResponseStructure;

//@ControllerAdvice
@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>>  handleIDNotFoundException(IdNotFoundException e)
	{
    	ResponseStructure<String> structure =new ResponseStructure<String>();
	  structure.setStatus(HttpStatus.NOT_FOUND.value());
	  structure.setMessage("Id Not Found");
	  structure.setData(e.getMessage());
	  return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	  
	}
	
	
	@ExceptionHandler(PhoneNumberNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>>  handlePhoneNumberNotFoundException(PhoneNumberNotFoundException e)
	{
    	ResponseStructure<String> structure =new ResponseStructure<String>();
	  structure.setStatus(HttpStatus.NOT_FOUND.value());
	  structure.setMessage("Phone Number Not Found");
	  structure.setData(e.getMessage());
	  return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	  
	}
	
	@ExceptionHandler(EmailNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>>  handleEmailNotFoundException(EmailNotFoundException e)
	{
    	ResponseStructure<String> structure =new ResponseStructure<String>();
	  structure.setStatus(HttpStatus.NOT_FOUND.value());
	  structure.setMessage("Email Not Found");
	  structure.setData(e.getMessage());
	  return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	  
	}

	
	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<ResponseStructure<String>>  handleNoDataFoundException(NoDataFoundException e)
	{
		
      ResponseStructure<String> structure =new ResponseStructure<String>();
	  structure.setStatus(HttpStatus.NOT_FOUND.value());
	  structure.setMessage("No Data Present");
	  structure.setData(e.getMessage());
	  return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	  
	}

	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleAddressNotFoundException(AddressNotFoundException e)
	{
		  ResponseStructure<String> structure =new ResponseStructure<String>();
		  structure.setStatus(HttpStatus.NOT_FOUND.value());
		  structure.setMessage("Address Not Found");
		  structure.setData(e.getMessage());
		  return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
}
