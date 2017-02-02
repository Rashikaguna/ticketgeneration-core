package com.rashika.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.rashika.model.UserInformation;
import com.rashika.util.ConnectionUtil;



public class UserInformationDAO {
	
	JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();
	
	public void save(UserInformation userInformation )
	{
		String sql="INSERT INTO USER_INFORMATION(NAME,EMAILID,PASSWORD) VALUES(?,?,?)";
		Object[] params={userInformation.getName(),userInformation.getEmailId(),userInformation.getPassword()};
		int rows= jdbcTemplate.update(sql, params);
		System.out.println("No. of rows:" +rows);
	}
	public void update(UserInformation userInformation) {

		String sql = "UPDATE USER_INFORMATION SET PASSWORD=? WHERE ID=?";
		Object[] params = {userInformation.getPassword(),userInformation.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}
	
	public void delete(int id) {

		String sql = "DELETE FROM USER_INFORMATION WHERE ID=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);

	}

	public List<UserInformation> listuserinformation() {
		String sql = "SELECT ID,NAME,EMAILID,PASSWORD,ISACTIVE FROM USER_INFORMATION";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			final UserInformation userInformation= convertForMenu(rs);
			return userInformation;
		});
	}
	
	public UserInformation convertForMenu(final ResultSet rs) throws SQLException {
		final UserInformation userInformation = new UserInformation();
userInformation.setId(rs.getInt("id"));
userInformation.setName(rs.getString("name"));
userInformation.setEmailId(rs.getString("emailId"));
userInformation.setPassword(rs.getString("password"));
userInformation.setActive(rs.getBoolean("isActive"));
return userInformation;
	}
	
}
