package com.hcl.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.employee.model.Employee;
import com.hcl.employee.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/employee/add")
	public  Employee addEmployee(@RequestBody Employee employee)
	{

		return employeeService.addEmployee(employee);
	}

	@GetMapping(value = "/employee/{code}")
	public  Employee viewEmployee(@PathVariable (name="code") Integer code)
	{
		return employeeService.viewEmployee(code);

	}

	@PatchMapping("/employee/edit")
	public Employee editEmployee(@RequestBody Employee employee)
	{

		return employeeService.editEmployee(employee);
	}
	
	@GetMapping("/employees")
	public  List<Employee> viewEmployees()
	{
		return employeeService.viewEmployees();
		
		
	}

}
