package com.employee.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.employee.response.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
 
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(EmployeeNotFoundException e,HttpServletRequest request){
		
		
		ErrorResponse errorResponse=ErrorResponse.builder()
												.message(e.getMessage())
												.status(HttpStatus.NOT_FOUND.value())
												.error(HttpStatus.NOT_FOUND.getReasonPhrase())
												.path(request.getRequestURI())
												.timestamp(LocalDateTime.now())
												.build();
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}

}
