package com.hcl.employee.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.employee.dao.EmployeeDao;
import com.hcl.employee.model.Employee;
import com.hcl.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDao employeeDao;

	@Override
	public Employee addEmployee(Employee employee) {
		
		
		return employeeDao.save(employee);
	}

	@Override
	public Employee viewEmployee(Integer code) {
		
		return employeeDao.findByCode(code);
	}

	@Override
	public Employee editEmployee(Employee employee) {
		
		return employeeDao.save(employee);
	}

	@Override
	public List<Employee> viewEmployees() {
		
		return (List<Employee>) employeeDao.findAll();
	}

}
