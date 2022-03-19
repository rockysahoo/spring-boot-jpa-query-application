package com.hcl.employee.service;

import java.util.List;
import java.util.Optional;

import com.hcl.employee.model.EmployeeActivity;

public interface EmployeeActivityService {



	public List<EmployeeActivity> retrieveEmployees();

	public EmployeeActivity getEmployee(Long Id);

	public Optional<List<EmployeeActivity>> getEmployeesWithIdAndSalary(Long id, Integer salary);


	List<EmployeeActivity> getEmployeesWithSalary(Integer min_salary, Integer salary);
}
