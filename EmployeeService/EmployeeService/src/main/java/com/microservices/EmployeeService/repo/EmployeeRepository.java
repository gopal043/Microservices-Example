package com.microservices.EmployeeService.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.EmployeeService.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> 
{
	Optional<Employee> findByDepartmentId(Long id);
	
	Optional<Employee> findByEmpId(Long id);

	List<Employee> empsWithDeptByOrgId(Long id);
	
	public Long deleteEmp(Long id);
}
