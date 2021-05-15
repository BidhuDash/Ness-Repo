package com.BEEmp.EmployeeBackEnd.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CutomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex,WebRequest rq){
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse(new Date(),ex.getMessage(),rq.getDescription(true));
		return new ResponseEntity<Object>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public final ResponseEntity<Object> handleEmployeeNotFoundException(Exception ex,WebRequest rq){
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse(new Date(),ex.getMessage(),rq.getDescription(true));
		return new ResponseEntity<Object>(exceptionResponse,HttpStatus.NOT_FOUND);
	}

}