package com.employee.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeRequestDTO;
import com.employee.dto.EmployeeResponseDTO;
import com.employee.service.EmployeeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	
	@PostMapping
	public ResponseEntity<EmployeeResponseDTO> createEmployee(@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(employeeService.createEmployee(employeeRequestDTO));
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeResponseDTO> getEmployeeById(@PathVariable Long id){
		return ResponseEntity.ok(employeeService.getEmployeeById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees(){
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeResponseDTO> updateEmployee(@PathVariable Long id,@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO){
		return ResponseEntity.ok(employeeService.updateEmployee(id, employeeRequestDTO));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.ok("Employee Deleted Successfully! ID : "+id);
	}
	
	
	@GetMapping("/department/{department}")
	public ResponseEntity<List<EmployeeResponseDTO>> getEmployeesByDepartment(@PathVariable String department){
		return ResponseEntity.ok(employeeService.getEmployeesByDepartment(department));
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<List<EmployeeResponseDTO>> getEmployeesByName(@PathVariable String name){
		return ResponseEntity.ok(employeeService.getEmployeesByName(name));
	}
	
	
	@GetMapping("/salary/{salary}")
	public ResponseEntity<List<EmployeeResponseDTO>> getEmployeesSalaryGreaterThan(@PathVariable Double salary){
		return ResponseEntity.ok(employeeService.getEmployeesSalaryGreaterThan(salary));
	}
	

}
