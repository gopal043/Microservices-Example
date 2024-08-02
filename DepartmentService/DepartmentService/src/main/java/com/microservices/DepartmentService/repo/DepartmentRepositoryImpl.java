package com.microservices.DepartmentService.repo;

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

import com.microservices.DepartmentService.entity.Department;

public class DepartmentRepositoryImpl implements DepartmentRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Department> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Department> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Department> entities) {
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
	public Department getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department getReferenceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Department> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Department> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Department> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Department> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Department> findById(Long id) {
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
	public void delete(Department entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Department> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Department> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Department> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Department> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Department> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Department> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Department> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Department, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings({ "deprecation" })
	@Override
	public Optional<Department> findByDptId(Long id) {
		String sql = "SELECT * FROM department1 WHERE id = ?";
		 Department department = jdbcTemplate.queryForObject(sql, new Object[]{id}, new DepartmentRowMapper());
    
		 return Optional.ofNullable(department);
	}
	
	@Override
	public List<Department> findAlll() {
		String sql = "SELECT * FROM department1";
        return jdbcTemplate.query(sql, new DepartmentRowMapper());
	}

	

	@Override
	public List<Department> deptsByOrgId(Long id) {
		String sql = "SELECT * FROM department1 where org_id = ?";
        return jdbcTemplate.query(sql, new Object[] {id},new DepartmentRowMapper());
	}
	
	
	 private static class DepartmentRowMapper implements RowMapper<Department> {
	        @Override
	        public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	Department department = new Department();
	        	department.setId(rs.getLong("ID"));
	        	department.setDeptName(rs.getString("DEPT_NAME"));
	            department.setDescription(rs.getString("DESCRIPTION"));
	            department.setEmail(rs.getString("EMAIL"));
	            department.setOrgId(rs.getLong("ORG_ID"));
	          
	            return department;
	        }
	    }
	 
	 
}
