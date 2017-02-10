package com.rashika.dao;

import com.rashika.exception.PersistanceException;
import com.rashika.model.TicketIssue;
import com.rashika.model.UserInformation;

public class TestCreateTicketDAO {

	public static void main(String[] args) throws PersistanceException {

		CreateTicketDAO createTicketdao = new CreateTicketDAO();
		UserInformation userinformation = new UserInformation();
		// userinformation.setId(1);
		// int userId=userinformation.getId();
		// userinformation.setName("kk");
		userinformation.setEmailId("rose@gmail.com");
		userinformation.setPassword("rose12");
		// TicketIssueDAO ticketIssueDAO = new TicketIssueDAO();
		////
//		TicketIssue ticketIssue = new TicketIssue();
//		ticketIssue.setId(3);
//		int issueId = ticketIssue.getId();
		// String description="failure of .. lksn";

		// String subject="system Failure";
		// String department="HUMAN RESOURCE";
		// String priority="low";
		// createTicketdao.createTicket(userinformation.getEmailId(),userinformation.getPassword(),
		// subject, description, department, priority);
		// createTicketdao.updateClose(userinformation.getEmailId(),userinformation.getPassword(),issueId);
		// createTicketdao.updateTicket(userinformation.getEmailId(),userinformation.getPassword(),
		// issueId, description);
		createTicketdao.findUserDetails(userinformation.getEmailId(), userinformation.getPassword());
		// createTicketdao.registration(userinformation.getEmailId(),userinformation.getEmailId(),userinformation.getPassword());

	}

}