package com.rashika.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.rashika.model.TicketFix;
import com.rashika.model.TicketIssue;
import com.rashika.util.ConnectionUtil;

public class TicketFixDAO  {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(TicketFix ticketfix) {
		String sql = "INSERT INTO TICKET_FIXES(EMPLOYEE_ID,TICKET_ID,SOLUTION) VALUES(?,?,?)";
		Object[] params = {ticketfix.getEmpId(),ticketfix.getTicketId(),ticketfix.getSolution()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println(rows);
	}

	
	public void update(TicketFix ticketFix) { 

	}

	
	public List<TicketFix> listAll() {
		String sql = "SELECT ID,TICKET_ID,SOLUTION FROM TICKET_FIXES";
		return jdbcTemplate.query(sql, (rs, rowNum) -> convert(rs));
	}

	private TicketFix convert(ResultSet rs) throws SQLException {
		TicketFix ticketFix = new TicketFix();
		TicketIssue ticketIssue = new TicketIssue();
		ticketFix.setId(rs.getInt("ID"));
		ticketIssue.setId(rs.getInt("TICKET_ID"));
		ticketFix.setTicketId(ticketIssue);
		ticketFix.setSolution(rs.getString("SOLUTION"));
		return ticketFix;
	}
	
	
	public void updateEmployeeId(TicketFix ticketFix) {
		String sql = "UPDATE TICKET_FIXES SET EMPLOYEE_ID=? WHERE TICKET_ID=?";
		Object[] params = {ticketFix.getEmpId().getId(),ticketFix.getTicketId().getId()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println(rows);

	} 
	public void delete(int issueId) {
		String sql = "DELETE FROM TICKET_FIXES WHERE TICKET_ID=?";
		Object params = issueId;
		int rows = jdbcTemplate.update(sql, params);
		System.out.println(rows);

	}

	
}