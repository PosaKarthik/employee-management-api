package com.posakarthik.employeemanagement.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.posakarthik.employeemanagement.dto.EmployeeRequestDTO;
import com.posakarthik.employeemanagement.dto.EmployeeResponseDTO;
import com.posakarthik.employeemanagement.entity.Employee;
import com.posakarthik.employeemanagement.exception.EmployeeNotFoundException;
import com.posakarthik.employeemanagement.mapper.EmployeeMapper;
import com.posakarthik.employeemanagement.repository.EmployeeRepository;
import com.posakarthik.employeemanagement.response.PageResponseDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
	
	private final EmployeeRepository employeeRepository;
	
	private final EmployeeMapper employeeMapper;
	
	private static final Logger logger=LoggerFactory.getLogger(EmployeeServiceImpl.class);
	

	@Override
	public EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO) {
		
		logger.info("Creating employee");
		
		Employee employee=Employee.builder()
							.employeeName(employeeRequestDTO.getEmployeeName())
							.employeeEmail(employeeRequestDTO.getEmployeeEmail())
							.employeeSalary(employeeRequestDTO.getEmployeeSalary())
							.employeeDepartment(employeeRequestDTO.getEmployeeDepartment())
						.build();
		
		Employee savedEntity=employeeRepository.save(employee);
		
		logger.info("Employee created successfully with id : {}",savedEntity.getEmployeeId());
		
						 				
		
		return employeeMapper.mapToDTO(savedEntity);
	}

	@Override
	public EmployeeResponseDTO getEmployeeById(Long id) {
		
		logger.info("Fethcing employee with id : {}",id);
		
		Employee employee=employeeRepository.findById(id)
										 .orElseThrow(
												 () -> new EmployeeNotFoundException("Employee not found with id : "+id));
				
		return employeeMapper.mapToDTO(employee);
	}

	@Override
	public List<EmployeeResponseDTO> getAllEmployees() {
		logger.info("Fetching all employees");
		
		List<Employee> employees=employeeRepository.findAll();
		return employees.stream()
						.map(employeeMapper::mapToDTO)
						.toList();
	}

	@Override
	public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO employeeRequestDTO) {
		
		logger.info("Updating employee with id : {}",id);
		
		Employee employee=employeeRepository.findById(id)
				.orElseThrow(
						 () -> new EmployeeNotFoundException("Employee not found with id : "+id));
		
		
		employee.setEmployeeName(employeeRequestDTO.getEmployeeName());
		employee.setEmployeeEmail(employeeRequestDTO.getEmployeeEmail());
		employee.setEmployeeSalary(employeeRequestDTO.getEmployeeSalary());
		employee.setEmployeeDepartment(employeeRequestDTO.getEmployeeDepartment());
		
		Employee updatedEmployee=employeeRepository.save(employee);
		
		logger.info("Employee updated successfully with id : {}",updatedEmployee.getEmployeeId());
		
		
		return employeeMapper.mapToDTO(updatedEmployee);
	
	}

	@Override
	public void deleteEmployee(Long id) {
		logger.info("Deleting employee with id :{}",id);
		
		Employee employee=employeeRepository.findById(id)
				.orElseThrow(
						 () -> new EmployeeNotFoundException("Employee not found with id : "+id));
		
		employeeRepository.deleteById(id);
		
		logger.info("Employee Deleted Successfully! ID : {}",id);
		
	}

	@Override
	public List<EmployeeResponseDTO> getEmployeesByDepartment(String department) {
		
		logger.info("Fetching employees from department {}",department);
		
		return employeeRepository.findByEmployeeDepartment(department)
									.stream()
									.map(employeeMapper::mapToDTO)
									.toList();
						
	}

	@Override
	public List<EmployeeResponseDTO> getEmployeesByName(String name) {
		
		logger.info("Fetching employees by name : {}",name);
		
		
		return employeeRepository.findByEmployeeName(name)
									.stream()
									.map(employeeMapper::mapToDTO)
									.toList();
	}

	@Override
	public List<EmployeeResponseDTO> getEmployeesSalaryGreaterThan(Double salary) {
		
		logger.info("Fetching employee with salary greater than {}",salary);
		
		return employeeRepository.findByEmployeeSalaryGreaterThan(salary)
									.stream()
									.map(employeeMapper::mapToDTO)
									.toList();
	}

	@Override
	public List<EmployeeResponseDTO> createEmployees(List<EmployeeRequestDTO> employeeRequestDTOs) {
		
		logger.info("Creating {} employees",employeeRequestDTOs.size());
		
		List<Employee> employees=employeeRequestDTOs.stream()
													.map(employeeMapper::mapToEntity)
													.toList();
		
		List<Employee> savedEmployees=employeeRepository.saveAll(employees);
		
		logger.info("Successfully created {} employees",savedEmployees.size());
		
		return savedEmployees.stream()
							 .map(employeeMapper::mapToDTO)
							 .toList();
	}

	@Override
	public PageResponseDTO<EmployeeResponseDTO> getAllEmployeesByPagination(int pageNumber, int pageSize, Sort.Direction direction, String sortBy) {
		
		logger.info("Fetching employees with pagination and sorting. Page: {}, Size: {}, SortBy: {}",pageNumber,pageSize,sortBy);
		
		Sort sort=Sort.by(direction, sortBy);
		
		Pageable pageable=PageRequest.of(pageNumber, pageSize, sort);
		
		Page<Employee> employeePage=employeeRepository.findAll(pageable);
		
		List<EmployeeResponseDTO> employeeDTOs=employeePage.getContent()
														.stream()
														.map(employeeMapper::mapToDTO)
														.toList();
		
		logger.info("Successfully fetched {} employees from page {}",employeeDTOs.size(),pageNumber);
		
		return PageResponseDTO.<EmployeeResponseDTO>builder()
								.content(employeeDTOs)
								.pageNumber(employeePage.getNumber())
								.pageSize(employeePage.getSize())
								.totalElements(employeePage.getTotalElements())
								.totalPages(employeePage.getTotalPages())
								.first(employeePage.isFirst())
								.last(employeePage.isLast())
								.hasNext(employeePage.hasNext())
								.hasPrevious(employeePage.hasPrevious())
								.build();						
								
	}

	
	
	
	
	
	
	

}
