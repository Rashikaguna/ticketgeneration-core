package com.rashika.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.rashika.model.Department;
import com.rashika.model.Employee;
import com.rashika.model.TicketInformation;
import com.rashika.model.UserInformation;
import com.rashika.util.ConnectionUtil;

public class TicketInformationDAO<FoodTransaction> {
JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();
	
	public void save(TicketInformation ticketInformation  )
	{
		String sql="INSERT INTO TICKET_INFORMATION(USER_ID,SUBJECT,DESCRIPTION,DEPARTMENT_ID,EMPLOYEE_ID,RESOLVED_DATE) VALUES(?,?,?,?,?,?)";
		Object[] params={ticketInformation.getUserId(),ticketInformation.getSubject(),ticketInformation.getDescription(),ticketInformation.getDeptId(),ticketInformation.getEmpId(),ticketInformation.getResolvedDate()};
		int rows= jdbcTemplate.update(sql, params);
		System.out.println("No. of rows:" +rows);
	}
	
	public void update(TicketInformation ticketInformation) {

		String sql = "UPDATE TICKET_INFORMATION SET STATUS=? WHERE ID=?";
		Object[] params = {ticketInformation.getStatus(),ticketInformation.getId()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}
	
	public void delete(int id) {

		String sql = "DELETE FROM TICKET_INFORMATION WHERE ID=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);

	}
	public TicketInformation convert(final ResultSet rs) throws SQLException {
		final TicketInformation ticketInformation = new TicketInformation();
ticketInformation.setId(rs.getInt("ID"));
UserInformation userInformation=new UserInformation();
userInformation.setId(rs.getInt("USER_ID"));
ticketInformation.setUserId(userInformation);
ticketInformation.setSubject(rs.getString("SUBJECT"));
ticketInformation.setDescription(rs.getString("DESCRIPTION"));
ticketInformation.setResolvedDate(rs.getTimestamp("CREATED_DATE").toLocalDateTime());
Department department=new Department();
department.setId(rs.getInt("DEPARTMENT_ID"));
ticketInformation.setDeptId(department);
Employee employee=new Employee();
employee.setId(rs.getInt("EMPLOYEE_ID"));
ticketInformation.setEmpId(employee);
ticketInformation.setResolvedDate(rs.getTimestamp("RESOLVED_DATE").toLocalDateTime());
ticketInformation.setStatus(rs.getString("STATUS"));
return ticketInformation;
	}
	
	public List<TicketInformation> listticket() {
		final String sql = "SELECT ID,USER_ID,SUBJECT,DESCRIPTION,CREATED_DATE,DEPARTMENT_ID,EMPLOYEE_ID,RESOLVED_DATE,STATUS FROM TICKET_INFORMATION";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			final TicketInformation ticketInformation = convert(rs);
			return ticketInformation;

		});
	}
}
