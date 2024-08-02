
package com.microservices.OrganizationService.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.OrganizationService.entity.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {


	List<Organization> findAlll();

	Optional<Organization> findByOrgId(Long id);
}
