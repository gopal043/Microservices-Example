package com.microservices.OrganizationService.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.microservices.OrganizationService.entity.Organization;

public class OrganizationRepositoryImpl implements OrganizationRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Organization> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Organization> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Organization> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public Organization getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Organization getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Organization getReferenceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Organization> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Organization> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Organization> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Organization> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Organization> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Organization> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Organization> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Organization entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Organization> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Organization> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Organization> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Organization> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Organization> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Organization> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Organization> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Organization, R> R findBy(Example<S> example,
			Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@SuppressWarnings({ "deprecation" })
	@Override
	public Optional<Organization> findByOrgId(Long id) {
		String sql = "SELECT * FROM Organization1 WHERE id = ?";
		Organization organization = jdbcTemplate.queryForObject(sql, new Object[]{id}, new OrganizationRowMapper());
    
		 return Optional.ofNullable(organization);
	}
	
	@Override
	public List<Organization> findAlll() {
		String sql = "SELECT * FROM Organization1";
        return jdbcTemplate.query(sql, new OrganizationRowMapper());
	}

	
	 private static class OrganizationRowMapper implements RowMapper<Organization> {
	        @Override
	        public Organization mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	Organization department = new Organization();
	        	department.setId(rs.getLong("id"));
	        	department.setName(rs.getString("name"));
	            department.setAddress(rs.getString("address"));
	          
	            return department;
	        }
	    }
	 

}
