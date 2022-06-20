package com.hcl.employee.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

	public List<EmployeeActivity> getEmployeesWithSalary(Integer min_salary, Integer max_salary){


		List<EmployeeActivity> employees =
				employeeActivityDao.findAll()
									.stream()
									.filter(emp_salary -> emp_salary.getSalary() >= min_salary &&
															emp_salary.getSalary() <= max_salary)
						//we can apply 2 filter() operations to obtain the result.
									//.filter(dept -> dept.getDepartment().equalsIgnoreCase("IT"))
									.collect(Collectors.toList());


		employees.forEach(employeesInnerData -> {

			System.out.println(employeesInnerData.getId() + employeesInnerData.getDepartment()
					+employeesInnerData.getName()+employeesInnerData.getSalary());

		});

		return employees;

	}

	public void addEmployees(List<EmployeeActivity> employeeActivity){

		employeeActivityDao.saveAll(employeeActivity);

	}


}
