
package com.microservices.EmployeeService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.EmployeeService.entity.Employee;
import com.microservices.EmployeeService.repo.EmployeeRepositoryImpl;
import com.microservices.EmployeeService.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired	
    private EmployeeRepositoryImpl employeeRepoImpl;
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		return employeeRepoImpl.findByEmpId(id)
				.orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
	}

	@PostMapping
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeRepoImpl.saveEmployee(employee);
	}

	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {

		Employee employee = employeeRepoImpl.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
		employee.setName(employeeDetails.getName());
		employee.setEmail(employeeDetails.getEmail());
		employee.setDepartmentId(employeeDetails.getDepartmentId());
		return employeeRepoImpl.save(employee);
	}

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		employeeRepoImpl.deleteById(id);
	}
	
	@GetMapping("department/{id}")
	public Employee findByDepartmentId(@PathVariable Long id) {
		return employeeRepoImpl.findByEmpId(id)
				.orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
	}

	
	@GetMapping("empsWithDeptByOrgId/{orgId}")
	public List<Employee> empsWithDeptByOrgId(@PathVariable Long orgId) {
		return employeeRepoImpl.empsWithDeptByOrgId(orgId);
	}
	
	@GetMapping("/deleteEmp/{id}")
	public String deleteEmp(@PathVariable Long id) {
		return employeeService.deleteEmp(id);
	}
	
}
