package com.gl.ems.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gl.ems.entity.Employee;
import com.gl.ems.repository.EmployeeRepository;
import com.gl.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public List<Employee> listEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
		return employeeRepository.getById(id);
	}

	@Override
	public void deleteEmployeeById(long id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

}
