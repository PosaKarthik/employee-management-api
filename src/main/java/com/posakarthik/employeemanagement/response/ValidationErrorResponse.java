package com.posakarthik.employeemanagement.response;

import java.time.LocalDateTime;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper=true)
@Schema(description="Validation error response")
public class ValidationErrorResponse extends ErrorResponse{
	
	
	@Schema(description="Validation errors")
	private List<FieldErrorDTO> errors;

	public ValidationErrorResponse(String message, int status, String error, String path, LocalDateTime timestamp,List<FieldErrorDTO> errors) {
		super(message, status, error, path, timestamp);
		this.errors=errors;
	}

	
	
	
	
}
