package com.gl.ems.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gl.ems.entity.Employee;
import com.gl.ems.service.EmployeeService;

@Controller
public class EmployeeController {
private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public String listEmployees(Model model) {
		
		List<Employee> employees = employeeService.listEmployees();
			
		model.addAttribute("employees", employees);
		
		return "employees";
	}
	
	@GetMapping("/employees/new")
	public String addEmployeeButtonClicked(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "add-employee";
	}
	
	@PostMapping("/employees")
	public String submitButtonClickedForAddEmployee(@ModelAttribute("employee")Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}
	
	@GetMapping("/employees/edit/{id}")
	public String updateButtonClicked(@PathVariable long id, Model model ) {
		Employee selectedEmployee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", selectedEmployee);
		return "update-employee";
	}
	
	@PostMapping("/employees/{id}")
	public String submitButtonClickedForUpdateEmployee(@PathVariable long id,@ModelAttribute("employee")Employee employee) {
		Employee existingEmployeeObj = employeeService.getEmployeeById(id);
		
		existingEmployeeObj.setFirstName(employee.getFirstName());
		existingEmployeeObj.setLastName(employee.getLastName());
		existingEmployeeObj.setEmail(employee.getEmail());
		
		employeeService.updateEmployee(employee);
		return "redirect:/employees";
	}
	
	@GetMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable long id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/employees";
	}

}
