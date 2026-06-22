package com.employee.service;

import com.employee.dto.EmployeeRequestDTO;
import com.employee.dto.EmployeeResponseDTO;

public interface EmployeeService {
	
	
	EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO);
	
	EmployeeResponseDTO getEmployeeById(Long id);

}
