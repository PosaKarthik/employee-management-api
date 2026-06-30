package com.employee.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.employee.response.ErrorResponse;
import com.employee.response.FieldErrorDTO;
import com.employee.response.ValidationErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
 
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException e,HttpServletRequest request){
		
		
		ErrorResponse errorResponse=ErrorResponse.builder()
												.message(e.getMessage())
												.status(HttpStatus.NOT_FOUND.value())
												.error(HttpStatus.NOT_FOUND.getReasonPhrase())
												.path(request.getRequestURI())
												.timestamp(LocalDateTime.now())
												.build();
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}
	
	
	//Spring MVC throws this exception
	
						//It contains validation errors
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e,HttpServletRequest request){
		
		List<FieldErrorDTO> fieldErrors=new ArrayList<>();
		
		//Spring stores all validation results in BindingResult
		
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

}
