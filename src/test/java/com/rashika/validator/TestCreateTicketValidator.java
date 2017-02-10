package com.rashika.validator;

import com.rashika.exception.ValidatorException;
import com.rashika.model.UserInformation;

public class TestCreateTicketValidator {
	public static void main(String[] args) {

		CreateTicketValidator c = new CreateTicketValidator();
		UserInformation us = new UserInformation();
		us.setEmailId("rashika@gmail.com");
		us.setPassword("rashika12");
		try {
			c.findUserDetails(us.getEmailId(), us.getPassword());
		} catch (ValidatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		ticketIssue.setId(3);
//		ticketIssue.setDescription("ajj");
//		try {
//			c.updateTicket(us.getEmailId(), us.getPassword(), ticketIssue.getId(), ticketIssue.getDescription());
//		} catch (ValidatorException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
	}
}