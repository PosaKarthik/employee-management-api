package com.employee.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper=true)
public class ValidationErrorResponse extends ErrorResponse{
	
	private List<FieldErrorDTO> errors;

	public ValidationErrorResponse(String message, int status, String error, String path, LocalDateTime timestamp,List<FieldErrorDTO> errors) {
		super(message, status, error, path, timestamp);
		this.errors=errors;
	}

	
	
	
	
}
