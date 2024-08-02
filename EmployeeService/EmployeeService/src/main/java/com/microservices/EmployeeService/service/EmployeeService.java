package com.microservices.EmployeeService.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.EmployeeService.entity.Employee;
import com.microservices.EmployeeService.repo.EmployeeRepositoryImpl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepositoryImpl employeeRepoImpl;

	@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefalutEmployee")
	public List<Employee> getAllEmployees() {
		return employeeRepoImpl.findAlll();
	}

	@Retry(name = "${spring.application.name}", fallbackMethod = "getDefalut")
	public String deleteEmp(Long id) {

		 employeeRepoImpl.deleteEmp(id);
		
		 return "Deleted Successfully !";
	}

	public List<Employee> getDefalutEmployee(Throwable t) {

		List<Employee> empList = new LinkedList<>();

		Employee employee = new Employee();

		employee.setId(0l);
		employee.setEmail("defaultemployee@gmail.com");
		employee.setDepartmentId(0l);
		employee.setName("Default");
		employee.setOrgId(0l);

		empList.add(employee);

		return empList;
	}

	public String getDefalut(Long id,Throwable t) {

		return "This is fallback Response";
	}

}
