package com.posakarthik.employeemanagement.response;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description="Standard error response")
public class ErrorResponse {
	
	@Schema(description="Error message",example="Employee not found with id : 10")
	private String message;
	
	@Schema(description="HTTP status code",example="404")
	private int status;
	
	@Schema(description="HTTP error",example="Not found")
	private String error;
	
	@Schema(description="Api path",example="/api/employees/10")
	private String path;
	
	@Schema(description="Time when the error occured",example="2026-07-07T12:30:45")
	private LocalDateTime timestamp;
	
	

}
