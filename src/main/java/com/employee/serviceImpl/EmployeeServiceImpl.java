package com.employee.serviceImpl;

import java.util.List;

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
	
	private EmployeeResponseDTO mapToDTO(Employee employee) {
		
		return EmployeeResponseDTO.builder()
				.employeeId(employee.getEmployeeId())
				.employeeName(employee.getEmployeeName())
				.employeeEmail(employee.getEmployeeEmail())
				.employeeSalary(employee.getEmployeeSalary())
				.employeeDepartment(employee.getEmployeeDepartment())
				.build();
	}

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
		
						 				
		
		return mapToDTO(savedEntity);
	}

	@Override
	public EmployeeResponseDTO getEmployeeById(Long id) {
		
		logger.info("Fethcing employee with id : {}",id);
		
		Employee employee=employeeRepository.findById(id)
										.orElse(null);
		
		if(employee == null) {
			logger.warn("Employee not found with : {}",id);
			return null;
		}
				

		return mapToDTO(employee);
	}

	@Override
	public List<EmployeeResponseDTO> getAllEmployees() {
		logger.info("Fetching all employees");
		
		List<Employee> employees=employeeRepository.findAll();
		return employees.stream()
						.map(this::mapToDTO)
						.toList();
	}

	@Override
	public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO employeeRequestDTO) {
		
		logger.info("Updating employee with id : {}",id);
		
		Employee employee=employeeRepository.findById(id)
											.orElse(null);
		
		if(employee == null) {
			logger.warn("Employee not found with : {}",id);
			return null;
		}
		
		employee.setEmployeeName(employeeRequestDTO.getEmployeeName());
		employee.setEmployeeEmail(employeeRequestDTO.getEmployeeEmail());
		employee.setEmployeeSalary(employeeRequestDTO.getEmployeeSalary());
		employee.setEmployeeDepartment(employeeRequestDTO.getEmployeeDepartment());
		
		Employee updatedEmployee=employeeRepository.save(employee);
		
		logger.info("Employee updated successfully with id : {}",updatedEmployee.getEmployeeId());
		
		
		return mapToDTO(updatedEmployee);
	
	}

	@Override
	public void deleteEmployee(Long id) {
		logger.info("Deleting employee wtih id :{}",id);
		
		Employee employee=employeeRepository.findById(id)
											.orElse(null);
		if(employee == null) {
			logger.warn("Employee not found with id :{}", id);
			return;
		}
		employeeRepository.deleteById(id);
		
		logger.info("Employee Deleted Successfully! ID : {}",id);
		
	}

	@Override
	public List<EmployeeResponseDTO> getEmployeesByDepartment(String department) {
		
		logger.info("Fetching employees from department {}",department);
		
		return employeeRepository.findByEmployeeDepartment(department)
									.stream()
									.map(this::mapToDTO)
									.toList();
						
	}

	@Override
	public List<EmployeeResponseDTO> getEmployeesByName(String name) {
		
		logger.info("Fetching employees by name : {}",name);
		
		
		return employeeRepository.searchByEmployeeName(name)
									.stream()
									.map(this::mapToDTO)
									.toList();
	}

	@Override
	public List<EmployeeResponseDTO> getEmployeesSalaryGreaterThan(Double salary) {
		
		logger.info("Fetching employee with salary greater than {}",salary);
		
		return employeeRepository.queryByEmployeeSalaryGreaterThan(salary)
									.stream()
									.map(this::mapToDTO)
									.toList();
	}

	
	
	
	
	
	
	

}
