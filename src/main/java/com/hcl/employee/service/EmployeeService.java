package com.hcl.employee.service;

import java.util.List;

import com.hcl.employee.model.Employee;



public interface EmployeeService {

	Employee addEmployee(Employee employee);

	Employee viewEmployee(Integer code);

	Employee editEmployee(Employee employee);

	List<Employee> viewEmployees();
	
	

}
