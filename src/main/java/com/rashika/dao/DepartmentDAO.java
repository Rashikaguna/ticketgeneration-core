package com.rashika.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.rashika.model.Department;
import com.rashika.util.ConnectionUtil;

public class DepartmentDAO {

JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();
	
	public void save(Department department )
	{
		String sql="INSERT INTO DEPARTMENT(DEPARTMENT) VALUES(?)";
		Object[] params={department.getDepartment()};
		int rows= jdbcTemplate.update(sql, params);
		System.out.println("No. of rows:" +rows);
	}
	public void update(Department department) {

		String sql = "UPDATE DEPARTMENT SET DEPARTMENT=? WHERE ID=?";
		Object[] params = {department.getDepartment(),department.getId()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}
	
	public void delete(int id) {

		String sql = "DELETE FROM DEPARTMENT WHERE ID=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);

	}
	
	public Department convertForMenu(final ResultSet rs) throws SQLException {
		final Department department = new Department();
department.setId(rs.getInt("ID"));
department.setDepartment(rs.getString("DEPARTMENT"));
department.setActive(rs.getBoolean("ISACTIVE"));
return department;
	}
	
	public List<Department> listdept() {
		String sql = "SELECT * FROM DEPARTMENT";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			final Department department= convertForMenu(rs);
			return department;
		});
	}
	
}
