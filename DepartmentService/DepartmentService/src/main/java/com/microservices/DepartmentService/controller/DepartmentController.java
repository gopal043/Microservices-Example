
package com.microservices.DepartmentService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.DepartmentService.entity.Department;
import com.microservices.DepartmentService.repo.DepartmentRepository;
import com.microservices.DepartmentService.util.Employee;
import com.microservices.DepartmentService.util.EmployeeClient;
import com.microservices.DepartmentService.util.ResponseClient;

@RestController

@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired(required = true)
	private EmployeeClient client;

	@GetMapping
	public List<Department> getAllDepartments() {
		return departmentRepository.findAlll();
	}

	@GetMapping("/{id}")
	public Optional<Department> getDepartmentById(@PathVariable Long id) {
		return  departmentRepository.findByDptId(id);
				//.orElseThrow(() -> new RuntimeException("Department not found with id: " + id));
	}

	@PostMapping
	public Department addDepartment(@RequestBody Department department) {
		return departmentRepository.save(department);
	}

	@PutMapping("/{id}")
	public Department updateDepartment(@PathVariable Long id, @RequestBody Department departmentDetails) {
		Department department = departmentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Department not found with id: " + id));
		department.setDeptName(departmentDetails.getDeptName());
		department.setDescription(departmentDetails.getDescription());
		return departmentRepository.save(department);
	}

	@DeleteMapping("/{id}")
	public void deleteDepartment(@PathVariable Long id) {
		departmentRepository.deleteById(id);
	}
	
	@GetMapping("employees/{id}")
	public ResponseClient getEmployeesByDepartmentId(@PathVariable Long id) {

		ResponseClient reponseClient = new ResponseClient();

		Optional<Department> department = departmentRepository.findByDptId(id);
		// .orElseThrow(() -> new RuntimeException("Department not found with id: " +
		// id));

		Employee employee =    client.getEmployeesByDepartment(id);
		
	
		System.out.println("employee :" + employee);

		reponseClient.setDepartment(department.get());
		reponseClient.setEmployee(employee);

		return reponseClient;
	}
	
	@GetMapping("deptsByOrgId/{orgId}")
	public List<Department> deptsByOrgId(@PathVariable Long orgId) {
		
		return departmentRepository.deptsByOrgId(orgId);
	}
}

