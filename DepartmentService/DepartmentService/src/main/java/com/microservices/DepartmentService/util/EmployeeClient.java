package com.microservices.DepartmentService.util;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name ="EMPLOYEE-SERVICE-APPLICATION")
public interface EmployeeClient {

	 @GetMapping("/employees/department/{Id}")
	Employee getEmployeesByDepartment(@PathVariable("Id") Long id);
}
