package com.rashika.service;

import com.rashika.exception.PersistanceException;
import com.rashika.exception.ServiceException;
import com.rashika.exception.ValidatorException;
import com.rashika.model.UserInformation;

public class TestTicketService {

	/**
	 * @param args
	 * @throws ServiceException
	 * @throws PersistenceException
	 */
	public static void main(String[] args) throws ServiceException, PersistanceException {
		TicketService ts = new TicketService();
		// CreateTicketDAO createTicket=new CreateTicketDAO();
		UserInformation user = new UserInformation();
		// user.setId(3);
		// int userId=user.getId();
		// user.setName("rina");
		user.setEmailId("rose@gmail.com");
		user.setPassword("rose12");

//		TicketIssue issue = new TicketIssue();
//		issue.setId(3);
//		int issueId = issue.getId();

		// String subject="Login Failure";
//		String description = "asdf";
		// String department="HUMAN RESOURCE";
		// String priority="High";
		// Employee employee=new Employee();
		// employee.setEmailId("regina@gmail.com");
		// employee.setPassword("regina12");
		// System.out.print(ts.emplogin(employee.getEmailId(),employee.getPassword()));
		// System.out.println(ts.login(user.getEmailId(), user.getPassword()));
try {
	ts.findUserDetail(user.getEmailId(), user.getPassword());
} catch (ValidatorException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}		
// ts.registration(user.getName(),user.getEmailId(),user.getPassword());
		// ts.createTicket(user.getEmailId(),user.getPassword(), subject,
		// description, department, priority);
//		ts.updateTicket(user.getEmailId(), user.getPassword(), issueId, description);
//		 ts.updateClose(user.getEmailId(),user.getPassword(),issueId);
		// ts.assignEmp(employee.getEmailId(),employee.getPassword(), issueId,
		// 1);
		// ts.deleteTickets(employee.getEmailId(),employee.getPassword(), 14);
		// ts.findEmployeeTickets(employee.getEmailId(),employee.getPassword());
	}

}