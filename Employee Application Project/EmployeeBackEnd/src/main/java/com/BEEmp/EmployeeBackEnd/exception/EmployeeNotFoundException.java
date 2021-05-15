package com.BEEmp.EmployeeBackEnd.exception;

@SuppressWarnings("serial")
public class EmployeeNotFoundException extends RuntimeException{
	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
