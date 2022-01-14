package com.hcl.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.employee.model.EmployeeActivity;
import com.hcl.employee.service.EmployeeActivityService;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api")
public class EmployeeActivityController {

	@Autowired
	EmployeeActivityService employeeActivityService;

	@GetMapping("/get/employees")
	public List<EmployeeActivity> getEmployees() {
		List<EmployeeActivity> employees;
		employees = employeeActivityService.retrieveEmployees();
		return employees;
	}

	@GetMapping("/get/employees/{Id}")
	public EmployeeActivity getEmployeeById(@PathVariable(name="Id")Long Id) {
		EmployeeActivity employees;
		employees = employeeActivityService.getEmployee(Id);
		return employees;
	}

	@GetMapping("/get/employees/filter/{id}/{salary}")
	public Optional<List<EmployeeActivity>> getEmployeesWithIdAndSalary(@PathVariable("id") Long id, @PathVariable("salary") Integer salary ) {
		Optional<List<EmployeeActivity>> employees;
		employees = employeeActivityService.getEmployeesWithIdAndSalary(id,salary);
		return employees;
	}

}
