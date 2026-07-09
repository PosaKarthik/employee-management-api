package com.posakarthik.employeemanagement.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.posakarthik.employeemanagement.response.ErrorResponse;
import com.posakarthik.employeemanagement.response.FieldErrorDTO;
import com.posakarthik.employeemanagement.response.ValidationErrorResponse;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {
	
	private static final Logger logger=LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
 
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException e,HttpServletRequest request){
		
		
		logger.error("Employee not found. Path: {}, Message: {}",request.getRequestURI(),e.getMessage());
		
		ErrorResponse errorResponse=ErrorResponse.builder()
												.message(e.getMessage())
												.status(HttpStatus.NOT_FOUND.value())
												.error(HttpStatus.NOT_FOUND.getReasonPhrase())
												.path(request.getRequestURI())
												.timestamp(LocalDateTime.now())
												.build();
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}
	
	

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e,HttpServletRequest request){
		
		
		logger.error("Validation failed for request: {}",request.getRequestURI());
		
		List<FieldErrorDTO> fieldErrors=new ArrayList<>();
		
		
		for(FieldError fieldError:e.getBindingResult().getFieldErrors()) {
			
			FieldErrorDTO fieldErrorDTO=FieldErrorDTO.builder()
													.field(fieldError.getField())
													.message(fieldError.getDefaultMessage())
													.build();
				fieldErrors.add(fieldErrorDTO);
		}
		
		ValidationErrorResponse validationErrorResponse =new ValidationErrorResponse("Validation Failed",
																					HttpStatus.BAD_REQUEST.value(),
																					HttpStatus.BAD_REQUEST.getReasonPhrase(),
																					request.getRequestURI(),
																					LocalDateTime.now(),
																					fieldErrors);
		
		return ResponseEntity.badRequest().body(validationErrorResponse);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception e,HttpServletRequest httpServletRequest){
		
		logger.error("Unexpected error occured. Path : {}, Message: {}",httpServletRequest.getRequestURI(),e.getMessage());
		
		ErrorResponse errorResponse=ErrorResponse.builder()
												.message("Something went wrong")
												.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
												.error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
												.path(httpServletRequest.getRequestURI())
												.timestamp(LocalDateTime.now())
												.build();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	}

}
