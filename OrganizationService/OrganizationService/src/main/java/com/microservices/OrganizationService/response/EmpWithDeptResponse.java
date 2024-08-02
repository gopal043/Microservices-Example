package com.microservices.OrganizationService.response;

import java.util.List;

import com.microservices.OrganizationService.entity.Organization;

public class EmpWithDeptResponse {

	private List<Department> department;
	private Organization organization;
	private List<Employee> employee;
	
	public EmpWithDeptResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmpWithDeptResponse(List<Department> department, Organization organization, List<Employee> employee) {
		super();
		this.department = department;
		this.organization = organization;
		this.employee = employee;
	}
	public List<Department> getDepartment() {
		return department;
	}
	public void setDepartment(List<Department> department) {
		this.department = department;
	}
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	
	
}
