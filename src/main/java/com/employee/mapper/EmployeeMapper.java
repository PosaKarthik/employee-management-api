package com.employee.mapper;

import org.springframework.stereotype.Component;

import com.employee.dto.EmployeeRequestDTO;
import com.employee.dto.EmployeeResponseDTO;
import com.employee.entity.Employee;

@Component
public class EmployeeMapper {

	
	public EmployeeResponseDTO mapToDTO(Employee employee) {
		
		return EmployeeResponseDTO.builder()
				.employeeId(employee.getEmployeeId())
				.employeeName(employee.getEmployeeName())
				.employeeEmail(employee.getEmployeeEmail())
				.employeeSalary(employee.getEmployeeSalary())
				.employeeDepartment(employee.getEmployeeDepartment())
				.build();
	}
	
	public Employee mapToEntity(EmployeeRequestDTO employeeRequestDTO) {
			
		return Employee.builder()
						.employeeName(employeeRequestDTO.getEmployeeName())
						.employeeEmail(employeeRequestDTO.getEmployeeEmail())
						.employeeSalary(employeeRequestDTO.getEmployeeSalary())
						.employeeDepartment(employeeRequestDTO.getEmployeeDepartment())
						.build();							
	}
}
