package com.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeResponseDTO {
	
	
	private Long employeeId;
	private String employeeName;
	private String employeeEmail;
	private Double employeeSalary;
	private String employeeDepartment;

}
