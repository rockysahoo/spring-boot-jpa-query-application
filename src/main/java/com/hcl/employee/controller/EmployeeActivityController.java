package com.hcl.employee.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hcl.employee.model.EmployeeActivity;
import com.hcl.employee.service.EmployeeActivityService;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api")
public class EmployeeActivityController {

	Logger logger = LoggerFactory.getLogger(EmployeeActivityController.class);

	@Autowired
	EmployeeActivityService employeeActivityService;


	@PostMapping("/add/employees")
	public ResponseEntity addEmployees(@RequestBody List<EmployeeActivity> employeeActivity) {


		employeeActivityService.addEmployees(employeeActivity);
		logger.info("employees added");
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/get/employees")
	public List<EmployeeActivity> getEmployees() {
		List<EmployeeActivity> employees;

		employees = employeeActivityService.retrieveEmployees();
		logger.info("employees :" +employees);
		return employees;
	}

	@GetMapping("/get/employees/{Id}")
	public EmployeeActivity getEmployeeById(@PathParam("Id") Long Id) { //if id not there then return null, not exception
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

	@GetMapping("/get/employees/filter/salary/{min_salary}/{max_salary}")
	public Optional<List<EmployeeActivity>> getEmployeesWithSalary(@PathVariable("min_salary") Integer min_salary,
																   @PathVariable("max_salary") Integer max_salary) {
		Optional<List<EmployeeActivity>> employees;
		employees = Optional.ofNullable(employeeActivityService.getEmployeesWithSalary(min_salary, max_salary));
		return employees;
	}

}
