package com.rashika.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.rashika.model.Department;
import com.rashika.model.Employee;
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
		String sql = "SELECT ID,NAME,DEPARTMENT_ID,EMAILID,PASSWORD,ISACTIVE FROM EMPLOYEE";
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
employee.setEmailId(rs.getString("EMAILID"));
employee.setPassword(rs.getString("PASSWORD"));
employee.setActive(rs.getBoolean("ISACTIVE"));
return employee;
	}
	
	
}
