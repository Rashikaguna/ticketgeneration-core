package com.rashika.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.rashika.exception.PersistanceException;
import com.rashika.model.Department;
import com.rashika.model.Employee;
import com.rashika.model.Role;
import com.rashika.model.TicketIssue;
import com.rashika.util.ConnectionUtil;

public class EmployeeDAO {

JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();
	
	public void save(Employee employee )
	{
		String sql="INSERT INTO EMPLOYEE(NAME,DEPARTMENT_ID,EMAILID,PASSWORD) VALUES(?,?,?,?)";
		Object[] params={employee.getName(),employee.getDeptId(),employee.getEmailId(),employee.getPassword()};
		int rows= jdbcTemplate.update(sql, params);
		System.out.println("No. of rows:" +rows);
	}
	public void update(Employee employee) {

		String sql = "UPDATE EMPLOYEE SET PASSWORD=? WHERE ID=?";
		Object[] params = {employee.getPassword(),employee.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}
	
	public void delete(int id) {

		String sql = "DELETE FROM EMPLOYEE WHERE ID=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);

	}
	
	public List<Employee> listemployee() {
		String sql = "SELECT ID,NAME,DEPARTMENT_ID,ROLE_ID,EMAILID,PASSWORD,ISACTIVE FROM EMPLOYEE";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			final Employee employee= convertForMenu(rs);
			return employee;
		});
	}
	
	public Employee convertForMenu(final ResultSet rs) throws SQLException {
		final Employee employee = new Employee();
employee.setId(rs.getInt("ID"));
employee.setName(rs.getString("NAME"));
Department department=new Department();
department.setId(rs.getInt("DEPARTMENT_ID"));
employee.setDeptId(department);
Role role=new Role();
role.setId(rs.getInt("ROLE_ID"));
employee.setRoleId(role);
employee.setEmailId(rs.getString("EMAILID"));
employee.setPassword(rs.getString("PASSWORD"));
employee.setActive(rs.getBoolean("ISACTIVE"));
return employee;
	}
	public Employee findOne(String emailId,String password) throws PersistanceException {
		
		try{
			String sql = "SELECT ID FROM EMPLOYEE WHERE EMAILID = ? AND PASSWORD=? AND ISACTIVE=1";
			Object[] params = { emailId,password };
			return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) ->{
				Employee employee=new Employee();
				employee.setId(rs.getInt("ID"));
				return employee;
			
			});
			
		}
		catch(EmptyResultDataAccessException e){
			throw new PersistanceException("Wrong Email id or Password",e);
		}
		}
	
public Employee findEmpRoleId(String emailId,String password) throws PersistanceException {
		
		try{
			String sql = "SELECT ROLE_ID FROM EMPLOYEE WHERE EMAILID = ? AND PASSWORD=? AND ISACTIVE=1";
			Object[] params = { emailId,password };
			return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) ->{
				Employee employee=new Employee();
				Role role=new Role();

				employee.setId(rs.getInt("ROLE_ID"));
				employee.setRoleId(role);
				return employee;
			
			});
			
		}
		catch(EmptyResultDataAccessException e){
			throw new PersistanceException("Wrong Email id or Password",e);
		}
		}


public Employee getEmployeeRoleId(int id) {
	String sql = "SELECT ROLE_ID FROM EMPLOYEE WHERE ID=?";
	Object[] params = { id };
	return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
		Employee employee = new Employee();
		Role role=new Role();
		role.setId(rs.getInt("ROLE_ID"));
		employee.setRoleId(role);
		return employee;
	});
}
public Employee findDepartmentId(int employeeId) {
	String sql = "SELECT DEPARTMENT_ID FROM EMPLOYEE WHERE ID = ? AND ISACTIVE=1";
	Object[] params = {employeeId};
	return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> {
		Employee employee=new Employee();
		Department department=new Department();
		department.setId(rs.getInt("DEPARTMENT_ID"));
		employee.setDeptId(department);;
		return employee;
	
	});


}
public Employee findEmployeeDepartmentId(String emailId,String password) {
	String sql = "SELECT DEPARTMENT_ID FROM EMPLOYEE WHERE EMAILID = ? AND PASSWORD=? AND ISACTIVE=1";
	Object[] params = {emailId,password};
	return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> {
		Employee employee=new Employee();
		Department department=new Department();
		department.setId(rs.getInt("DEPARTMENT_ID"));
		employee.setDeptId(department);
		return employee;
	});
}

	
	
}
