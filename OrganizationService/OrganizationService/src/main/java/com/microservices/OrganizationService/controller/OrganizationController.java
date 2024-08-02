
package com.microservices.OrganizationService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.OrganizationService.clients.DepartmentClient;
import com.microservices.OrganizationService.clients.EmployeeClient;
import com.microservices.OrganizationService.entity.Organization;
import com.microservices.OrganizationService.repo.OrganizationRepository;
import com.microservices.OrganizationService.response.Department;
import com.microservices.OrganizationService.response.DepartmentResponse;
import com.microservices.OrganizationService.response.EmpWithDeptResponse;
import com.microservices.OrganizationService.response.Employee;

@RestController

@RequestMapping("/organizations")
public class OrganizationController {

	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Autowired
	private DepartmentClient departmentClient;
	
	@Autowired
	private EmployeeClient employeeClient;

	@GetMapping
	public List<Organization> getAllOrganizations() {
		return organizationRepository.findAlll();
	}

	@GetMapping("/{id}")
	public Organization getOrganizationById(@PathVariable Long id) {
		return organizationRepository.findByOrgId(id)
				.orElseThrow(() -> new RuntimeException("Organization not found with id: " + id));
	}

	@PostMapping
	public Organization addOrganization(@RequestBody Organization organization) {
		return organizationRepository.save(organization);
	}

	@PutMapping("/{id}")
	public Organization updateOrganization(@PathVariable Long id, @RequestBody Organization organizationDetails) {
		Organization organization = organizationRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Organization not found with id: " + id));
		organization.setName(organizationDetails.getName());
		organization.setAddress(organizationDetails.getAddress());
		return organizationRepository.save(organization);
	}

	@DeleteMapping("/{id}")
	public void deleteOrganization(@PathVariable Long id) {
		organizationRepository.deleteById(id);
	}
	
	@GetMapping("deptsByOrgId/{orgId}")
	public DepartmentResponse deptsByOrgId(@PathVariable Long orgId) {
		
		DepartmentResponse departmentResponse = new DepartmentResponse();
		
		Optional<Organization> organization = organizationRepository.findByOrgId(orgId);
		
		List<Department> department =  departmentClient.deptsByOrgId(orgId);
		 
		departmentResponse.setDepartment(department);
		departmentResponse.setOrganization(organization.get());
		
		return departmentResponse;
	}
	
	@GetMapping("empsWithDeptByOrgId/{orgId}")
	public EmpWithDeptResponse empsWithDeptByOrgId(@PathVariable Long orgId) {
		
		EmpWithDeptResponse empWithDeptResponse = new EmpWithDeptResponse();
		
		Optional<Organization> organization = organizationRepository.findByOrgId(orgId);
		
		List<Department> department =  departmentClient.deptsByOrgId(orgId);
		
		List<Employee> employee =  employeeClient.empsWithDeptByOrgId(orgId);
		
		empWithDeptResponse.setOrganization(organization.get());
		empWithDeptResponse.setDepartment(department);
		empWithDeptResponse.setEmployee(employee);
		
		return empWithDeptResponse;
	}
	
	
	
}








