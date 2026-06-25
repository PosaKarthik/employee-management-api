package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
	List<Employee> findByEmployeeDepartment(String department);
	
	List<Employee> searchByEmployeeName(String name);
	
	List<Employee> queryByEmployeeSalaryGreaterThan(Double salary);

}
