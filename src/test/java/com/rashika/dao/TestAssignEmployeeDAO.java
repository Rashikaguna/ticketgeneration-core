package com.rashika.dao;

import com.rashika.exception.PersistanceException;
import com.rashika.model.Employee;
import com.rashika.model.TicketIssue;

public class TestAssignEmployeeDAO {
	public static void main(String[] args) throws PersistanceException {
		
	AssignEmployeeDAO assign=new AssignEmployeeDAO();
      Employee employee=new Employee();
   //   employee.setId(1);
      TicketIssue ticketIssue=new TicketIssue();
        ticketIssue.setId(9);
	int issueId=ticketIssue.getId();
        employee.setEmailId("regina@gmail.com");
      employee.setPassword("regina12");
      assign.assignEmployee(employee.getEmailId(), employee.getPassword(), issueId, employee.getId());
     //  assign.findEmployeeTickets(employee.getEmailId(), employee.getPassword());
    //  assign.deleteTickets(employee.getEmailId(), employee.getPassword(), issueId);
       
}
}