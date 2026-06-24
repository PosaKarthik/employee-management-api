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

}
