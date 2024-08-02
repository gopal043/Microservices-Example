package com.microservices.OrganizationService.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.OrganizationService.response.Department;

@FeignClient("DEPARTMENT-SERVICE-APPLICATION")
public interface DepartmentClient {

	@GetMapping("/departments/deptsByOrgId/{orgId}")
	public List<Department> deptsByOrgId(@PathVariable("orgId") Long orgId);
}
