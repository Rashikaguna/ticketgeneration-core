package com.rashika.validator;

import com.rashika.exception.ValidatorException;
import com.rashika.util.Validator;

public class CreateTicketValidator {

	Validator validator=new Validator();
	public void registration(String name,String emailId,String password) throws ValidatorException{
		Validator.isInvalid(name, "NAME");
		Validator.isInvalid(emailId, "EMAILID");
		Validator.isInvalid(password, "PASSWORD");
	}
	public void createTicket(String emailId,String password,String subject,String description,String department,String priority) throws ValidatorException{
	
		Validator.isInvalid(emailId, "EMAIL");
		Validator.isInvalid(password, "PASSWORD");
		Validator.isInvalid(subject, "SUBJECT");
		Validator.isInvalid(description, "DESCRIPTION");
		Validator.isInvalid(department, "DEPARTMENT");
		Validator.isInvalid(priority, "PRIORITY");
	}
	public void updateTicket(String emailId,String password,int issueId,String updateDescription) throws ValidatorException{
		
		Validator.isInvalid(emailId, "EMAIL");
		Validator.isInvalid(password, "PASSWORD");
		Validator.isInvalid(issueId, "TICKET_ID");
		Validator.isInvalid(updateDescription, "DESCRIPTION");
	}
	
	public void updateClose(String emailId,String password,int issueId) throws ValidatorException{
		
		Validator.isInvalid(emailId, "EMAIL");
		Validator.isInvalid(password, "PASSWORD");
		Validator.isInvalid(issueId, "TICKET_ID");
		
	}
	
	public void findUserDetails(String emailId,String password) throws ValidatorException{
		
		Validator.isInvalid(emailId, "EMAIL");
		Validator.isInvalid(password, "PASSWORD");
		
	}
}