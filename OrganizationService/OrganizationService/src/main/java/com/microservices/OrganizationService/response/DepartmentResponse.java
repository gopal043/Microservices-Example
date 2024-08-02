package com.microservices.OrganizationService.response;

import java.util.List;

import com.microservices.OrganizationService.entity.Organization;

public class DepartmentResponse {

	private List<Department> department;
	private Organization organization;
	
	public DepartmentResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DepartmentResponse(List<Department> department, Organization organization) {
		super();
		this.department = department;
		this.organization = organization;
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
	
	
}
