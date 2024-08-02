package com.microservices.OrganizationService.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.OrganizationService.response.Employee;

@FeignClient("EMPLOYEE-SERVICE-APPLICATION")
public interface EmployeeClient {

	@GetMapping("/employees/empsWithDeptByOrgId/{orgId}")
	public List<Employee> empsWithDeptByOrgId(@PathVariable("orgId") Long orgId);
}
