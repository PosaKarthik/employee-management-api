package com.employee.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeRequestDTO;
import com.employee.dto.EmployeeResponseDTO;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
	
	private final EmployeeRepository employeeRepository;
	
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
		
						 				
		
		return EmployeeResponseDTO.builder()
				.employeeId(savedEntity.getEmployeeId())
				.employeeName(savedEntity.getEmployeeName())
				.employeeEmail(savedEntity.getEmployeeEmail())
				.employeeSalary(savedEntity.getEmployeeSalary())
				.employeeDepartment(savedEntity.getEmployeeDepartment())
				.build();
	}

	@Override
	public EmployeeResponseDTO getEmployeeById(Long id) {
		
		logger.info("Fethcing employee with id : {}",id);
		
		Employee employee=employeeRepository.findById(id)
										.orElse(null);
		
		if(employee == null) {
			logger.info("Employee not found with : {}",id);
			return null;
		}
				

		return EmployeeResponseDTO.builder()
				.employeeId(employee.getEmployeeId())
				.employeeName(employee.getEmployeeName())
				.employeeEmail(employee.getEmployeeEmail())
				.employeeSalary(employee.getEmployeeSalary())
				.employeeDepartment(employee.getEmployeeDepartment())
				.build();
	}
	
	

}
