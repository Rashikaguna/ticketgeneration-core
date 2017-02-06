package com.rashika.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.rashika.model.Role;
import com.rashika.util.ConnectionUtil;

public class RoleDAO {
JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();
	
	public void save(Role role )
	{
		String sql="INSERT INTO ROLE(NAME) VALUES(?)";
		Object[] params={role.getRole()};
		int rows= jdbcTemplate.update(sql, params);
		System.out.println("No. of rows:" +rows);
	}
	public void update(Role role) {

		String sql = "UPDATE ROLE SET NAME=? WHERE ID=?";
		Object[] params = {role.getRole(),role.getId()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}
	
	public void delete(int id) {

		String sql = "DELETE FROM ROLE WHERE ID=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);

	}
	
	public Role findRoleId(Role role) {
		String sql = "SELECT ID FROM ROLE WHERE NAME = ? AND ISACTIVE=1";
		Object[] params = {role.getRole()};
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> {
			Role roles=new Role();
			roles.setId(rs.getInt("ID"));
			return roles;
		});
	}
}
