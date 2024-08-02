package com.microservices.DepartmentService.util;

import java.util.List;

import com.microservices.DepartmentService.entity.Department;

public class ResponseClient {

	private Department department;
	private Employee employee;
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public ResponseClient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResponseClient(Department department, Employee employee) {
		super();
		this.department = department;
		this.employee = employee;
	}
	
	
	
	
}
