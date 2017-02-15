package com.rashika.service;

import java.util.Iterator;
import java.util.List;

import com.rashika.dao.UserInformationDAO;
import com.rashika.exception.PersistanceException;
import com.rashika.exception.ServiceException;
import com.rashika.exception.ValidatorException;
import com.rashika.model.Employee;
import com.rashika.model.TicketIssue;
import com.rashika.model.UserInformation;

public class TestTicketService {

	/**
	 * @param args
	 * @throws ServiceException
	 * @throws PersistenceException
	 */
	public static void main(String[] args) throws ServiceException, PersistanceException {
		TicketService ticketService = new TicketService();
		// CreateTicketDAO createTicket=new CreateTicketDAO();
		UserInformation user = new UserInformation();
		UserInformationDAO userInformationDAO=new UserInformationDAO();
		// user.setId(3);
		// int userId=user.getId();
		// user.setName("rina");
		user.setEmailId("rashika@gmail.com");
		user.setPassword("rashika12");
		TicketIssue ticketIssue=new TicketIssue();
		
		int userId=userInformationDAO.findId(user.getEmailId()).getId();
		user.setId(userId);
		ticketIssue.setUserId(user);
		List<TicketIssue> l=ticketService.findUserDetails(ticketIssue);
		Iterator i = l.iterator();
		while (i.hasNext()) {
			TicketIssue ticketIssue2 = (TicketIssue) i.next();
			System.out.println(ticketIssue2.getId()+"\t"+ ticketIssue2.getUserId().getId()
					+"\t"+ticketIssue2.getSubject()
					+"\t"+ticketIssue2.getDescription()
					+"\t"+ticketIssue2.getPriority()+"\t"+ticketIssue2.getStatus());
		}
//System.out.println(ts.findUserDetails(issue));
//		TicketIssue issue = new TicketIssue();
//		issue.setId(3);
//		int issueId = issue.getId();

		// String subject="Login Failure";
//		String description = "asdf";
		// String department="HUMAN RESOURCE";
		// String priority="High";
		 Employee employee=new Employee();
		 employee.setEmailId("roshni@gmail.com");
		 employee.setPassword("roshni12");
		// System.out.print(ticketService.emplogin(employee.getEmailId(),employee.getPassword()));
		// System.out.println(ticketService.login(user.getEmailId(), user.getPassword()));
		
// ts.registration(user.getName(),user.getEmailId(),user.getPassword());
		// ticketService.createTicket(user.getEmailId(),user.getPassword(), subject,
		// description, department, priority);
//		ticketService.updateTicket(user.getEmailId(), user.getPassword(), issueId, description);
//		 ticketService.updateClose(user.getEmailId(),user.getPassword(),issueId);
		// ticketService.assignEmp(employee.getEmailId(),employee.getPassword(), issueId,
		// 1);
//		 ticketService.deleteTickets(employee.getEmailId(),employee.getPassword(), 21);
		 ticketService.findEmployeeTickets(employee.getEmailId(),employee.getPassword());
	}

}
