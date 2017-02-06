package com.rashika.dao;

import java.util.Iterator;
import java.util.List;

import com.rashika.exception.PersistanceException;
import com.rashika.model.Employee;
import com.rashika.model.Role;
import com.rashika.model.TicketFix;
import com.rashika.model.TicketIssue;

public class AssignEmployeeDAO {
    TicketIssue ticketIssue=new TicketIssue();

	public void assignEmployee(String emailId, String password, int ticketId, int employeeId)throws PersistanceException {
		LoginDAO loginDao = new LoginDAO();

		try {
			if (loginDao.employeeLogin(emailId, password)) {
				Employee employee = new Employee();
				employee.setEmailId(emailId);
				employee.setPassword(password);
				EmployeeDAO employeeDao = new EmployeeDAO();
				int currentEmployeeDepartmentId = employeeDao.findEmployeeDepartmentId(emailId, password)
						.getDeptId().getId();
				int givenEmployeeDepartmentId = employeeDao.findDepartmentId(employeeId).getDeptId().getId();

				if (currentEmployeeDepartmentId == givenEmployeeDepartmentId) {
                     TicketFix ticketFix=new TicketFix();
                     TicketFixDAO ticketFixDAO=new TicketFixDAO();
                     TicketIssueDAO ticketIssueDAO=new TicketIssueDAO();
					ticketIssue.setId(ticketId);
					ticketFix.setTicketId(ticketIssue);

					employee.setId(employeeId);
					ticketFix.setEmpId(employee);
                     
					ticketFixDAO.updateEmployeeId(ticketFix);
                     ticketIssueDAO.updateProgressStatus(ticketIssue);
				} else {
					System.out.println("Department do not match");
				}

			}
		} catch (PersistanceException e) {
			throw new PersistanceException("Login Failed", e);
		}

	}
	
	public void deleteTickets(String emailId, String password, int issueId) throws PersistanceException {
		LoginDAO loginDao = new LoginDAO();
		try {
			if (loginDao.employeeLogin(emailId, password)) {
				Employee employee=new Employee();
				EmployeeDAO employeeDao=new EmployeeDAO();
				employee.setEmailId(emailId);
				employee.setPassword(password);
				int employeeRoleId=employeeDao.findEmpRoleId(emailId, password).getRoleId().getId();
				
				Role role=new Role();
				role.setRole("Admin");
				RoleDAO roleDao=new RoleDAO();
				int adminRoleId=roleDao.findRoleId(role).getId();

				if(employeeRoleId==adminRoleId){
					TicketFixDAO ticketFixDAO=new TicketFixDAO();
					TicketIssueDAO ticketIssue=new TicketIssueDAO();
					ticketFixDAO.delete(issueId);
					ticketIssue.deleteticket(issueId);
				}
				else{
					System.out.println("Only admin can delete a ticket");
				}
				
				
			}

	}catch (PersistanceException e) {
		throw new PersistanceException("Login Failed", e);
	}

}
	
	public void findEmployeeTickets(String emailId, String password) throws PersistanceException{
		LoginDAO loginDao = new LoginDAO();
		try {
			if (loginDao.employeeLogin(emailId, password)) {
				Employee employee=new Employee();
				EmployeeDAO employeeDao=new EmployeeDAO();
				employee.setEmailId(emailId);
				employee.setPassword(password);
				int employeeId=employeeDao.findOne(emailId, password).getId();
				TicketIssueDAO ticketIssue=new TicketIssueDAO();
				ticketIssue.findempTickets(employeeId);
				List<TicketIssue> list = ticketIssue.findempTickets(employeeId);
				Iterator<TicketIssue> i = list.iterator();
				while (i.hasNext()) {
					TicketIssue issue = (TicketIssue) i.next();
					System.out.println(issue.getId()+ "\t" +issue.getSubject() + "\t"
							+ issue.getDescription() +"\t"+issue.getStatus());
				}
				
			}
		
	}catch (PersistanceException e) {
		throw new PersistanceException("Login Failed", e);
	}
		
}
	
}
