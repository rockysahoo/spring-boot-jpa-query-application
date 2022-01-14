package com.hcl.employee.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.employee.dao.EmployeeActivityDao;
import com.hcl.employee.model.EmployeeActivity;
import com.hcl.employee.service.EmployeeActivityService;

@Service
public class EmployeeActivityImpl implements EmployeeActivityService{

	@Autowired(required = true)
	EmployeeActivityDao employeeActivityDao;
	
	

	public List<EmployeeActivity> retrieveEmployees() {
		List<EmployeeActivity> employees = (List<EmployeeActivity>) employeeActivityDao.findAll();
		return employees;
	}

	public EmployeeActivity getEmployee(Long Id) {
		Optional<EmployeeActivity> optEmp = employeeActivityDao.findByIdWIthQuery(Id);
		return optEmp.get();
	}


	public Optional<List<EmployeeActivity>> getEmployeesWithIdAndSalary(Long id, Integer salary) {
		Optional<List<EmployeeActivity>> employees =
				employeeActivityDao.getEmployeesWithIdAndSalary(id,salary);
		return employees;
	}



}
