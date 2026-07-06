package com.employee.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description="Employee Response Object")
public class EmployeeResponseDTO {
	
	@Schema(description="Unique Employee ID",example="1")
	private Long employeeId;
	
	@Schema(description="Employee Name",example="Arjun Sarkar")
	private String employeeName;
	
	@Schema(description="Employee Email",example="Arjunsarkar@gmail.com")
	private String employeeEmail;
	
	@Schema(description="EmployeeSalary",example="50000.0")
	private Double employeeSalary;
	
	@Schema(description="Employee Department",example="IT")
	private String employeeDepartment;

}
