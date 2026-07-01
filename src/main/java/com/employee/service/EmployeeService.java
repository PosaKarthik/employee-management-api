package com.employee.service;

import java.util.List;

import com.employee.dto.EmployeeRequestDTO;
import com.employee.dto.EmployeeResponseDTO;

public interface EmployeeService {
	
	
	EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO);
	
	EmployeeResponseDTO getEmployeeById(Long id);
	
	List<EmployeeResponseDTO> getAllEmployees();
	
	EmployeeResponseDTO updateEmployee(Long id,EmployeeRequestDTO employeeRequestDTO);
	
	void deleteEmployee(Long id);
	
	List<EmployeeResponseDTO> getEmployeesByDepartment(String department);
	
	List<EmployeeResponseDTO> getEmployeesByName(String name);
	
	List<EmployeeResponseDTO> getEmployeesSalaryGreaterThan(Double salary);
	
	List<EmployeeResponseDTO> createEmployees(List<EmployeeRequestDTO> employeeRequestDTO);

}
