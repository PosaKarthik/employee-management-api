package com.employee.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeRequestDTO;
import com.employee.dto.EmployeeResponseDTO;
import com.employee.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	
	@PostMapping
	public ResponseEntity<EmployeeResponseDTO> createEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(employeeService.createEmployee(employeeRequestDTO));
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeResponseDTO> getEmployeeById(@PathVariable Long id){
		return ResponseEntity.ok(employeeService.getEmployeeById(id));
	}
	
	

}
