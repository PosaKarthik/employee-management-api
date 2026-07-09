package com.posakarthik.employeemanagement.mapper;

import org.springframework.stereotype.Component;

import com.posakarthik.employeemanagement.dto.EmployeeRequestDTO;
import com.posakarthik.employeemanagement.dto.EmployeeResponseDTO;
import com.posakarthik.employeemanagement.entity.Employee;

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
