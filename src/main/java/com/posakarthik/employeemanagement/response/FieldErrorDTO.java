package com.posakarthik.employeemanagement.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description="Validation error details")
public class FieldErrorDTO {
	
	
	@Schema(description="Error field",example="employeeEmail")
	private String field;
	
	@Schema(description="Validation meassage",example="Email should be valid")
	private String message;
	

}
