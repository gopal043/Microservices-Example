package com.microservices.EmployeeService.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.microservices.EmployeeService.entity.Employee;

@Repository
@Primary
public class EmployeeRepositoryImpl implements EmployeeRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Employee> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Employee> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Employee> entities) {
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
	public Employee getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getReferenceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Employee> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Employee> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Employee> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Employee> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Employee> findById(Long id) {
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
	public void delete(Employee entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Employee> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Employee> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Employee> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Employee> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Employee> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Employee> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Employee, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Employee> findAlll() {
        String sql = "SELECT * FROM employee1";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }
	
	public Employee saveEmployee(Employee employee) {
        String sql = "INSERT INTO employee1 (name, department_Id,email) VALUES (?, ?,?)";
        jdbcTemplate.update(sql, employee.getName(), employee.getDepartmentId(),employee.getEmail());
		return employee;
    }

    private static class EmployeeRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setId(rs.getLong("id"));
            employee.setName(rs.getString("name"));
            employee.setEmail(rs.getString("email"));
            employee.setDepartmentId(rs.getLong("department_Id"));
            return employee;
        }
    }

	@Override
	public Optional<Employee> findByDepartmentId(Long id) {
		String sql = "SELECT * FROM employee1 WHERE DEPARTMENT_ID = ?";
		 Employee employee = jdbcTemplate.queryForObject(sql, new Object[]{id}, new EmployeeRowMapper());
   
		 return Optional.ofNullable(employee);
	}

	@Override
	public Optional<Employee> findByEmpId(Long id) {
		String sql = "SELECT * FROM employee1 WHERE id = ?";
		 Employee employee = jdbcTemplate.queryForObject(sql, new Object[]{id}, new EmployeeRowMapper());
   
		 return Optional.ofNullable(employee);
	}
    
	
	
	@Override
	public List<Employee> empsWithDeptByOrgId(Long id) {
		String sql = "SELECT * FROM employee1 WHERE ORG_ID = ?";
		 List<Employee> employee =  jdbcTemplate.query(sql, new Object[]{id}, new EmployeeRowMapper());
   
		 return employee;
	}
	
	public Long deleteEmp(Long id) {
		
		String sql = "Delete FROM employee1 WHERE id = ?";
		
		return jdbcTemplate.queryForObject(sql, Long.class);
	}

}
