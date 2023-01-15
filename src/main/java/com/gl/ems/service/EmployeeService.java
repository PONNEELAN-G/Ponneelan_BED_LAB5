package com.gl.ems.service;

import java.util.List;

import com.gl.ems.entity.Employee;

public interface EmployeeService {
	
	List<Employee> listEmployees();
	
	Employee saveEmployee(Employee employee);
	
	Employee updateEmployee(Employee employee);
	
	Employee getEmployeeById(long id);
	
	void deleteEmployeeById(long id);
}
