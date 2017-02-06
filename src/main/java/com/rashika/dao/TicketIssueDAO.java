package com.rashika.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.rashika.model.Department;
import com.rashika.model.TicketIssue;
import com.rashika.model.UserInformation;
import com.rashika.util.ConnectionUtil;

public class TicketIssueDAO  {
	private static JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	
	public void save(TicketIssue ticketissue) {
	String sql = "INSERT INTO TICKET_ISSUES(USER_ID,SUBJECT,DESCRIPTION,DEPARTMENT_ID,PRIORITY)VALUES(?,?,?,?,?)";
	Object[] params = {ticketissue.getUserId().getId(),ticketissue.getSubject(),ticketissue.getDescription(),ticketissue.getDepartmentId().getId(),ticketissue.getPriority()};
	int rows = jdbcTemplate.update(sql, params);
	System.out.println(rows);
}
	
	public void updateDescription(TicketIssue ticketIssue) {
		String sql = "UPDATE TICKET_ISSUES SET DESCRIPTION=?,STATUS='OPEN' WHERE ID=? AND USER_ID=?";
		Object[] params = {ticketIssue.getDescription(),ticketIssue.getId(),ticketIssue.getUserId().getId()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println(rows);

	}
	
	public void updateClose(TicketIssue ticketIssue) {
		String sql = "UPDATE TICKET_ISSUES SET STATUS='CLOSED' WHERE ID=? AND USER_ID=?";
		Object[] params = {ticketIssue.getId(),ticketIssue.getUserId().getId()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println(rows);

	}
	
	
public void delete(int id) {
	String sql = "DELETE FROM ISSUES WHERE ID=?";
	Object params = id;
	int rows = jdbcTemplate.update(sql, params);
	System.out.println(rows);

}
	

public List<TicketIssue> findAll() {
	String sql = "SELECT ID,USER_ID,DEPARTMENT_ID,SUBJECT,DESCRIPTION,CREATED_DATE,RESOLVED_DATE,STATUS,PRIORITY FROM TICKET_ISSUES";
	return jdbcTemplate.query(sql, (rs, rowNo) -> {
	
	final TicketIssue ticketIssue = convert(rs);
	return ticketIssue;

});

}

public static List<TicketIssue> findUserDetails(int userId) {
	String sql = "SELECT ID,USER_ID,DEPARTMENT_ID,SUBJECT,DESCRIPTION,CREATED_DATE,RESOLVED_DATE,STATUS,PRIORITY FROM TICKET_ISSUES WHERE USER_ID=?";
	Object[] params = { userId };
	return jdbcTemplate.query(sql,params, (rs, rowNo) -> convert(rs));

}

public TicketIssue findOne(int id) {
	String sql = "SELECT ID,USER_ID,DEPARTMENT_ID,SUBJECT,DESCRIPTION,CREATED_DATE,RESOLVED_DATE,STATUS,PRIORITY FROM TICKET_ISSUES WHERE ID = ?";
	Object[] params = { id };
	return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> convert(rs));

}

public TicketIssue getStatus(int id) {
	String sql = "SELECT STATUS FROM TICKET_ISSUES WHERE ID=?";
	Object[] params = { id };
	return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
		TicketIssue ticketIssue = new TicketIssue();
		ticketIssue.setStatus(rs.getString("STATUS"));
		return ticketIssue;
	});
}


public TicketIssue findStatus(int id,int userId) {
	String sql = "SELECT STATUS FROM TICKET_ISSUES WHERE  ID = ? AND USER_ID=?";
	Object[] params = { id,userId };
	return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> {
	TicketIssue ticketIssue=new TicketIssue();
		ticketIssue.setStatus(rs.getString("STATUS"));
		return ticketIssue;
	
	});

}

private static TicketIssue convert(ResultSet rs) throws SQLException {
	TicketIssue ticketIssue = new TicketIssue();
	ticketIssue.setId(rs.getInt("ID"));
	
	UserInformation userInformation=new UserInformation();
	userInformation.setId(rs.getInt("USER_ID"));
	ticketIssue.setUserId(userInformation);
	
	Department department=new Department();
	department.setId(rs.getInt("DEPARTMENT_ID"));
	ticketIssue.setDepartmentId(department);
	
	ticketIssue.setSubject(rs.getString("SUBJECT"));
	ticketIssue.setDescription(rs.getString("DESCRIPTION"));
	ticketIssue.setCreatedDate(rs.getTimestamp("CREATED_DATE").toLocalDateTime());
	//ticketIssue.setResolvedDate(rs.getDate("RESOLVED_DATE").toLocalDate());
	ticketIssue.setStatus(rs.getString("STATUS"));
	ticketIssue.setPriority(rs.getString("PRIORITY"));
	return ticketIssue;
}

public List<TicketIssue> findUserDetail(int userId) {
	String sql = "SELECT ID,USER_ID,SUBJECT,DESCRIPTION,CREATED_DATE,STATUS,PRIORITY FROM TICKET_ISSUES WHERE USER_ID=?";
	Object[] params = { userId };
	return jdbcTemplate.query(sql,params, (rs, rowNo) ->{
		TicketIssue ticketIssue=new TicketIssue();
		ticketIssue.setId(rs.getInt("ID"));
		
		UserInformation userinformation=new UserInformation();
		userinformation.setId(rs.getInt("USER_ID"));
		ticketIssue.setUserId(userinformation);
		
		ticketIssue.setSubject(rs.getString("SUBJECT"));
		ticketIssue.setDescription(rs.getString("DESCRIPTION"));
		ticketIssue.setStatus(rs.getString("STATUS"));
		ticketIssue.setPriority(rs.getString("PRIORITY"));
		return ticketIssue;
	
	});

}

public void updateProgressStatus(TicketIssue ticketissue) {
	String sql = "UPDATE TICKET_ISSUES SET STATUS='In Progress' WHERE ID=?";
	Object[] params = { ticketissue.getId() };
	int rows = jdbcTemplate.update(sql, params);
	System.out.println(rows);

}

public void updateResolvedStatus(TicketIssue ticketissue) {
	String sql = "UPDATE TICKET_ISSUES SET STATUS='Resolved',DATE_RESOLVED=NOW() WHERE ID=?";
	Object[] params = { ticketissue.getId() };
	int rows = jdbcTemplate.update(sql, params);
	System.out.println(rows);

}
public void deleteticket(int id) {
	String sql = "DELETE FROM TICKET_ISSUES WHERE ID=?";
	Object params = id;
	int rows = jdbcTemplate.update(sql, params);
	System.out.println(rows);

}

public List<TicketIssue> findempTickets(int empId) {
	String sql = "SELECT TICKET_ISSUES.ID,SUBJECT,DESCRIPTION,STATUS,PRIORITY FROM TICKET_ISSUES , TICKET_FIXES WHERE TICKET_ISSUES.ID=TICKET_FIXES.TICKET_ID AND  TICKET_FIXES.EMPLOYEE_ID=?";
	Object[] params = { empId };
	return jdbcTemplate.query(sql, params, (rs, rowNo) -> {
		TicketIssue issue = new TicketIssue();

		issue.setId(rs.getInt("ID"));
		issue.setSubject(rs.getString("SUBJECT"));
		issue.setDescription(rs.getString("DESCRIPTION"));
		issue.setStatus(rs.getString("STATUS"));
		issue.setPriority(rs.getString("PRIORITY"));

		return issue;

	});

}

}