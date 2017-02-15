package com.rashika.service;

import java.util.List;

import com.rashika.dao.AssignEmployeeDAO;
import com.rashika.dao.CreateTicketDAO;
import com.rashika.dao.LoginDAO;
import com.rashika.exception.PersistanceException;
import com.rashika.exception.ServiceException;
import com.rashika.exception.ValidatorException;
import com.rashika.model.TicketIssue;
import com.rashika.validator.CreateTicketValidator;

public class TicketService {
	LoginDAO logindao = new LoginDAO();
	AssignEmployeeDAO assignEmployeeDAO = new AssignEmployeeDAO();
	CreateTicketValidator createTicketValidator = new CreateTicketValidator();
	CreateTicketDAO createTicketDAO = new CreateTicketDAO();

	public void registration(String name, String emailId, String password) throws ServiceException {

		try {
			createTicketValidator.registration(name, emailId, password);
			createTicketDAO.registration(name, emailId, password);
		} catch (ValidatorException | PersistanceException e) {
			throw new ServiceException("Registration Failed", e);
		}
	}

	public void createTicket(String emailId, String password, String subject, String description, String department,
			String priority) throws ServiceException {

		try {
			createTicketValidator.createTicket(emailId, password, subject, description, department, priority);
			createTicketDAO.createTicket(emailId, password, subject, description, department, priority);
		} catch (ValidatorException | PersistanceException e) {
			throw new ServiceException("Cannot Create Ticket", e);

		}
	}

	public boolean login(String emailId, String password) throws ServiceException, PersistanceException {

		try {
			createTicketValidator.login(emailId, password);
			logindao.login(emailId, password);
		} catch (ValidatorException e) {
			throw new ServiceException("Login Failed", e);
		}
		return true;
	}

	public boolean emplogin(String emailId, String password) throws ServiceException, PersistanceException {

		try {
			createTicketValidator.login(emailId, password);
			logindao.employeeLogin(emailId, password);
		} catch (ValidatorException e) {
			throw new ServiceException("Login Failed", e);
		}
		return true;
	}

	public void updateTicket(String emailId, String password, int issueId, String updateDescription)
			throws ServiceException {

		try {
			createTicketValidator.updateTicket(emailId, password, issueId, updateDescription);
			createTicketDAO.updateTicket(emailId, password, issueId, updateDescription);
		} catch (ValidatorException | PersistanceException e) {
			throw new ServiceException("Cannot Update Ticket", e);

		}
	}

	public void updateClose(String emailId, String password, int issueId) throws ServiceException {

		try {
			createTicketValidator.updateClose(emailId, password, issueId);
			createTicketDAO.updateClose(emailId, password, issueId);
		} catch (ValidatorException | PersistanceException e) {
			throw new ServiceException("Cannot Close Ticket", e);

		}
	}

	

	

	public void assignEmp(String emailId, String password, int issueId, int employeeId) throws ServiceException {

		try {
			createTicketValidator.assignEmployee(emailId, password, issueId, employeeId);
			assignEmployeeDAO.assignEmployee(emailId, password, issueId, employeeId);
		} catch (ValidatorException | PersistanceException e) {
			throw new ServiceException("Cannot Assign Ticket", e);

		}
	}

	public List<TicketIssue> findEmployeeTickets(String emailId, String password) throws ServiceException {
		try {
			return assignEmployeeDAO.findEmployeeTickets(emailId, password);
		} catch (PersistanceException e) {
			throw new ServiceException("Cannot View Ticket", e);
		}
	}

	public void deleteTickets(String emailId, String password, int issueId) throws ServiceException {

		try {
			createTicketValidator.deleteTickets(emailId, password, issueId);
			assignEmployeeDAO.deleteTickets(emailId, password, issueId);
		} catch (ValidatorException | PersistanceException e) {
			throw new ServiceException("Cannot Delete Ticket", e);

		}

	}

	public List<TicketIssue> findUserDetails(TicketIssue issue) throws ServiceException {
		try {
			return createTicketDAO.findUserTicket(issue);
		} catch (PersistanceException e) {
			throw new ServiceException("Cannot View Ticket", e);
		}
	}

	public void assignEmployee(String emailId, String password, int ticketId, int employeeId) throws ServiceException {

		try {
			createTicketValidator.assignEmployee(emailId, password, ticketId, employeeId);
			assignEmployeeDAO.assignEmployee(emailId, password, ticketId, employeeId);

		} catch (ValidatorException | PersistanceException e) {
			throw new ServiceException("Cannot Assign Ticket", e);

		}
	}

}
