package com.posakarthik.employeemanagement.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.posakarthik.employeemanagement.dto.EmployeeRequestDTO;
import com.posakarthik.employeemanagement.dto.EmployeeResponseDTO;
import com.posakarthik.employeemanagement.response.PageResponseDTO;

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
	
	PageResponseDTO<EmployeeResponseDTO> getAllEmployeesByPagination(int pageNumber,int pageSize, Sort.Direction direction, String sortBy);

}
