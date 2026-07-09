package com.posakarthik.employeemanagement.dto;



import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description="Employee Request Object")
public class EmployeeRequestDTO {

	@Schema(description="Employee Name",example="Arjun Sarkar")
	@NotBlank(message="Employee name is required")
	private String employeeName;
	
	@Schema(description="Employee Email",example="Arjunsarkar@gmail.com")
	@Email(message="Enter valid email")
	@NotBlank(message="Email is required")
	private String employeeEmail;
	
	@Schema(description="Employee Salary",example="50000")
	@NotNull(message="Salary is required")
	@Min(value=10000,message="Salary must be at least 10000")
	private Double employeeSalary;
	
	@Schema(description="EmployeeDeaprtment",example="IT")
	@NotBlank(message="Department is required")
	private String employeeDepartment;
}
