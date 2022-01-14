package com.hcl.employee.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.employee.model.EmployeeActivity;


@Repository
public interface EmployeeActivityDao extends JpaRepository<EmployeeActivity, Long> {

	@Query(value="Select * from EMPLOYEE_ACTIVITY e where e.ID= :Id" ,nativeQuery = true)
	Optional<EmployeeActivity> findByIdWIthQuery(Long Id);

	@Query(value = "Select * from EMPLOYEE_ACTIVITY e where e.ID= :id AND e.EMPLOYEE_SALARY = :salary", nativeQuery = true)
	Optional<List<EmployeeActivity>> getEmployeesWithIdAndSalary(Long id, Integer salary);

}
