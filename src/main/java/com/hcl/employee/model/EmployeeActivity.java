package com.hcl.employee.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.sql.Date;

import javax.persistence.*;


@Entity
@Table(name="EMPLOYEE_ACTIVITY")
public class EmployeeActivity {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	/*@ManyToOne
	@JoinColumn(name = "ID")
	@NotFound(action = NotFoundAction.IGNORE)*/
	private Long id;

	//@Column(name="DEPARTMENT")
	@JsonProperty("DEPARTMENT")
	private String department;

	//@Column(name="EMPLOYEE_NAME")
	@JsonProperty("EMPLOYEE_NAME")
	private String name;

	//@Column(name="EMPLOYEE_SALARY")
	@JsonProperty("EMPLOYEE_SALARY")
	private Integer salary;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "EmployeeActivity{" +
				"id=" + id +
				", name='" + name + '\'' +
				", salary=" + salary +
				", department='" + department + '\'' +
				'}';
	}
}
