package com.rashika.service;

import com.rashika.dao.AssignEmployeeDAO;
import com.rashika.dao.CreateTicketDAO;
import com.rashika.dao.LoginDAO;
import com.rashika.exception.PersistanceException;
import com.rashika.exception.ServiceException;
import com.rashika.exception.ValidatorException;
import com.rashika.validator.CreateTicketValidator;

public class TicketService {
	LoginDAO logindao = new LoginDAO();
	AssignEmployeeDAO assignEmployeeDAO = new AssignEmployeeDAO();
	CreateTicketValidator createTicketValidator = new CreateTicketValidator();
	CreateTicketDAO createTicketdao = new CreateTicketDAO();

	public void registration(String name, String emailId, String password) throws ServiceException {

		try {
			createTicketValidator.registration(name, emailId, password);
			createTicketdao.registration(name, emailId, password);
		} catch (ValidatorException | PersistanceException e) {
			throw new ServiceException("Registration Failed", e);
		}
	}

	public void createTicket(String emailId, String password, String subject, String description, String department,
			String priority) throws ServiceException {

		try {
			createTicketValidator.createTicket(emailId, password, subject, description, department, priority);
			createTicketdao.createTicket(emailId, password, subject, description, department, priority);
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
			createTicketdao.updateTicket(emailId, password, issueId, updateDescription);
		} catch (ValidatorException | PersistanceException e) {
			throw new ServiceException("Cannot Update Ticket", e);

		}
	}

	public void updateClose(String emailId, String password, int issueId) throws ServiceException {

		try {
			createTicketValidator.updateClose(emailId, password, issueId);
			createTicketdao.updateClose(emailId, password, issueId);
		} catch (ValidatorException | PersistanceException e) {
			throw new ServiceException("Cannot Close Ticket", e);

		}
	}

	// public List<TicketIssue> findUserDetails(TicketIssue ticketIssue) throws
	// ServiceException{
	// try {
	// return createTicketdao.findUserDetails(ticketIssue);
	// } catch (PersistanceException e) {
	// throw new ServiceException("Cannot View Ticket", e);
	// }
	// }
	//
	//

	public void findUserDetails(String emailId, String password) throws ServiceException {
		try {
			createTicketValidator.findUserDetails(emailId, password);
			createTicketdao.findUserDetails(emailId, password);
		} catch (ValidatorException | PersistanceException e) {
			throw new ServiceException("Cannot View Ticket", e);
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

	public void findEmployeeTickets(String emailId, String password) throws ServiceException {

		try {
			createTicketValidator.findEmployeeTickets(emailId, password);
			assignEmployeeDAO.findEmployeeTickets(emailId, password);
		} catch (ValidatorException | PersistanceException e) {
			throw new ServiceException("Cannot View Tickets", e);

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

	public void findUserDetail(String emailId, String password) throws ServiceException, ValidatorException {
		// TODO Auto-generated method stub
		createTicketValidator.findUserDetails(emailId, password);
		try {
			createTicketdao.findUserDetails(emailId, password);
		} catch (PersistanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}