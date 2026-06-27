package com.employee.dto;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDTO {

	@NotBlank(message="Employee name is required")
	private String employeeName;
	
	@Email(message="Enter valid email")
	@NotBlank(message="Email is required")
	private String employeeEmail;
	
	@NotNull(message="Salary is required")
	@Min(value=10000,message="Salary must be at least 10000")
	private Double employeeSalary;
	
	@NotBlank(message="Department is required")
	private String employeeDepartment;
}
