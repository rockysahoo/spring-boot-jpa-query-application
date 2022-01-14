package com.hcl.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.employee.model.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	
	
	Employee findByCode(Integer code);
	
	
	

}
