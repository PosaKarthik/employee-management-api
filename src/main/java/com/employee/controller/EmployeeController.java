package com.employee.controller;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeRequestDTO;
import com.employee.dto.EmployeeResponseDTO;
import com.employee.response.ErrorResponse;
import com.employee.response.PageResponseDTO;
import com.employee.response.ValidationErrorResponse;
import com.employee.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
@Tag(name = "Employee Controller", description = "APIs for managing employee operations")
public class EmployeeController {

	private final EmployeeService employeeService;

	@Operation(summary = "Create Employee", description = "Creates a new employee")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "Employee created successfully"),
			@ApiResponse(responseCode = "400", description = "Validation failed", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorResponse.class))) })
	@PostMapping
	public ResponseEntity<EmployeeResponseDTO> createEmployee(
			@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employeeRequestDTO));
	}

	@Operation(summary = "Get employee by ID", description = "Fetches an employee using the employee ID")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Employee found successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeResponseDTO.class))),
			@ApiResponse(responseCode = "404", description = "Employee not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeResponseDTO> getEmployeeById(
			@Parameter(description = "Employee ID", example = "1", required = true) @PathVariable Long id) {
		return ResponseEntity.ok(employeeService.getEmployeeById(id));
	}

	@Operation(summary = "Get all employees", description = "Fetches all employees from the database")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Employees fetched successfully") })
	@GetMapping
	public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees() {
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}

	@Operation(summary = "Update employee", description = "Updates an existing employee using the employee ID")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Employee updates successfully"),
			@ApiResponse(responseCode = "400", description = "Validation failed", content = @Content(mediaType = "applicaiton/json", schema = @Schema(implementation = ValidationErrorResponse.class))),
			@ApiResponse(responseCode = "404", description = "Employee not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeResponseDTO> updateEmployee(
			@Parameter(description = "Employee ID", example = "1", required = true) @PathVariable Long id,
			@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO) {
		return ResponseEntity.ok(employeeService.updateEmployee(id, employeeRequestDTO));
	}

	@Operation(summary = "Delete employee", description = "Delete an employee using employee ID")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Employee deleted successfully"),
			@ApiResponse(responseCode = "404", description = "Employee not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(
			@Parameter(description = "Employee ID", example = "1", required = true) @PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.ok("Employee Deleted Successfully! ID : " + id);
	}

	@Operation(summary = "Search employees by department", description = "Fetches employees belonging to a specific department")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Employees fetched successfully") })
	@GetMapping("/department/{department}")
	public ResponseEntity<List<EmployeeResponseDTO>> getEmployeesByDepartment(
			@Parameter(description = "Employee Department", example = "IT", required = true) @PathVariable String department) {
		return ResponseEntity.ok(employeeService.getEmployeesByDepartment(department));
	}

	@Operation(summary = "Search employees by name", description = "Fetches employees whose names match the given keyword")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Employees fetched successfully") })
	@GetMapping("/name/{name}")
	public ResponseEntity<List<EmployeeResponseDTO>> getEmployeesByName(
			@Parameter(description = "Employee Name", example = "ArjunSarkar", required = true) @PathVariable String name) {
		return ResponseEntity.ok(employeeService.getEmployeesByName(name));
	}

	@Operation(summary = "Search employees by salary", description = "Fetches employees whose salary is greater than the specified amount")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Employees fetched successfully") })
	@GetMapping("/salary/{salary}")
	public ResponseEntity<List<EmployeeResponseDTO>> getEmployeesSalaryGreaterThan(
			@Parameter(description = "Employee Salary", example = "50000.0", required = true) @PathVariable Double salary) {
		return ResponseEntity.ok(employeeService.getEmployeesSalaryGreaterThan(salary));
	}

	@Operation(summary = "Create multiple employees", description = "Creates multiple employees in a single request")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "Employees created successfully"),
			@ApiResponse(responseCode = "400", description = "Validation failed", content = @Content(mediaType = "applicaiton/json", schema = @Schema(implementation = ValidationErrorResponse.class))) })
	@PostMapping("/batch")
	public ResponseEntity<List<EmployeeResponseDTO>> createEmployees(
			@Valid @RequestBody List<EmployeeRequestDTO> employeeRequestDTOs) {
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployees(employeeRequestDTOs));
	}

	@Operation(summary = "Get employees with pagination and sorting", description = "Fetches employees using pagination and optional sorting")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Employees fetched successfully") })
	@GetMapping("/pagination-and-sorting")
	public ResponseEntity<PageResponseDTO<EmployeeResponseDTO>> getAllEmployeesByPagination(
			@Parameter(description = "Page number (starts from 0)", example = "0") @RequestParam(defaultValue = "0") int pageNumber,
			@Parameter(description = "Number of records per page", example = "5") @RequestParam(defaultValue = "5") int pageSize,
			@Parameter(description = "Sort direction", example = "DESC") @RequestParam(defaultValue = "ASC") Sort.Direction direction,
			@Parameter(description = "Employee field used for sorting", example = "employeeSalary") @RequestParam(defaultValue = "employeeId") String sortBy) {
		return ResponseEntity.ok(employeeService.getAllEmployeesByPagination(pageNumber, pageSize, direction, sortBy));
	}

}
