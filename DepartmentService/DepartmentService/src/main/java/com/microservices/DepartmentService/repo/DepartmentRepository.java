
package com.microservices.DepartmentService.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.DepartmentService.entity.Department;

@Repository

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	Optional<Department> findByDptId(Long id);

	List<Department> findAlll();

	List<Department> deptsByOrgId(Long id);
}
