package com.rashika.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.rashika.model.TicketIssue;
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
	public UserInformation find1(String emailId,String pas) {
		String sql="SELECT NAME FROM USER_INFORMATION WHERE EMAILID=? AND PASSWORD=?";
		Object[] params={emailId,pas};
		return jdbcTemplate.queryForObject(sql, params,(rs,rowNo) -> {
			UserInformation userInformation=new UserInformation();
			userInformation.setName(rs.getString("NAME"));
			return userInformation;
			
		});
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
			final UserInformation userInformation= convert(rs);
			return userInformation;
		});
	}
	
	public UserInformation convert(final ResultSet rs) throws SQLException {
		final UserInformation userInformation = new UserInformation();
userInformation.setId(rs.getInt("id"));
userInformation.setName(rs.getString("name"));
userInformation.setEmailId(rs.getString("emailId"));
userInformation.setPassword(rs.getString("password"));
userInformation.setActive(rs.getBoolean("isActive"));
return userInformation;
	}
	
	public UserInformation findOne(String emailId) {
		String sql="SELECT PASSWORD FROM USER_INFORMATION WHERE EMAILID=?";
		Object[] params={emailId};
		return jdbcTemplate.queryForObject(sql, params,(rs,rowNo) -> {
			UserInformation userInformation=new UserInformation();
			userInformation.setPassword(rs.getString("PASSWORD"));
			return userInformation;
			
		});
		}
	public UserInformation findId(String emailId) {
		String sql = "SELECT ID FROM USER_INFORMATION WHERE EMAILID=?";
		Object[] params = { emailId };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> {
			UserInformation userInformation=new UserInformation();
			userInformation.setId(rs.getInt("ID"));
			return userInformation;
		
		});

	}



}






	
	

