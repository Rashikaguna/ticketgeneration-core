package com.rashika.dao;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.mail.EmailException;

import com.rashika.exception.PersistanceException;
import com.rashika.model.Department;
import com.rashika.model.TicketIssue;
import com.rashika.model.UserInformation;
import com.rashika.util.MailUtil;

public class CreateTicketDAO {
	TicketIssue ticketIssue=new TicketIssue();
	TicketIssueDAO ticketIssueDAO=new TicketIssueDAO();
	
	public void registration(String name,String emailId,String password) throws PersistanceException{
		UserInformation userinformation=new UserInformation();
		UserInformationDAO userDao=new UserInformationDAO();
		
		userinformation.setName(name);
		userinformation.setEmailId(emailId);
		userinformation.setPassword(password);
		
		userDao.save(userinformation);
	}
	public void createTicket(String emailId,String password,String subject,String description,String department,String priority) throws PersistanceException{

	LoginDAO loginDao=new LoginDAO();
	if(loginDao.login(emailId, password)){
			
		UserInformation userinformation=new UserInformation();
		UserInformationDAO userinformationdao=new UserInformationDAO();
		
		int userId=userinformationdao.findId(emailId).getId();
		userinformation.setId(userId);
		ticketIssue.setUserId(userinformation);
		
		ticketIssue.setSubject(subject);
		ticketIssue.setDescription(description);
		
		Department departments=new Department();
		DepartmentDAO departmentdao=new DepartmentDAO();
		int departmentId=departmentdao.findId(department).getId();
		departments.setId(departmentId);
		ticketIssue.setDepartmentId(departments);
		ticketIssue.setPriority(priority);
		ticketIssueDAO.save(ticketIssue);
		try {
			MailUtil.sendSimpleMail();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	else
	{
		System.out.println("Incorrect user name or password");
	}
}
	
	public void updateTicket(String emailId,String password,int issueId,String updateDescription) throws PersistanceException{
		
		LoginDAO loginDao=new LoginDAO();
		if(loginDao.login(emailId, password)){
			UserInformation userinformation=new UserInformation();
			UserInformationDAO userinformationDao=new UserInformationDAO();
			
			int userId=userinformationDao.findId(emailId).getId();
			userinformation.setId(userId);
			ticketIssue.setUserId(userinformation);
			
//			if( "CLOSED".equals(ticketIssueDAO.findStatus(userId, issueId).getStatus()) ){
//		
//			System.out.println("You can't update now!");
//			}
//		else
//		{
//	
			ticketIssue.setUserId(userinformation);
		
			ticketIssue.setId(issueId);
			ticketIssue.setStatus("Inprogress");
			ticketIssue.setDescription(updateDescription);
		
			ticketIssueDAO.updateDescription(ticketIssue);
//		}
	}
		else
		{
			System.out.println("Incorrect user name or password");
		}
}
	
	public void updateClose(String emailId,String password,int issueId) throws PersistanceException{
		
		LoginDAO loginDao=new LoginDAO();
		if(loginDao.login(emailId, password)){
			
		UserInformation userinformation=new UserInformation();
		UserInformationDAO userinformationdao=new UserInformationDAO();
			
		int userId=userinformationdao.findId(emailId).getId();
		userinformation.setId(userId);
		ticketIssue.setUserId(userinformation);
		
		ticketIssue.setId(issueId);
		
		ticketIssueDAO.updateClose(ticketIssue);
		}
		else{
			System.out.println("Incorrect user name or password");
		}
	}
	public List<TicketIssue> findUserTicket(TicketIssue issue) throws PersistanceException{
		return ticketIssueDAO.findUserTickets(issue);
	}
	
	
	public void findUserDetails(String emailId,String password) throws PersistanceException{
		LoginDAO loginDao=new LoginDAO();
		if(loginDao.login(emailId, password)){
			
		UserInformation userinformation=new UserInformation();
		UserInformationDAO userinformationDao=new UserInformationDAO();
			
		int userId=userinformationDao.findId(emailId).getId();
		userinformation.setId(userId);
		ticketIssueDAO.findUserDetails(userinformation.getId());
		
		List<TicketIssue> list = TicketIssueDAO.findUserDetails(userId);
		Iterator<TicketIssue> i = list.iterator();
		while (i.hasNext()) {
			TicketIssue ticketIssue = (TicketIssue) i.next();
			System.out.println(ticketIssue.getId()+ "\t"+ticketIssue.getUserId().getId()+"\t" +ticketIssue.getSubject() + "\t"
					+ ticketIssue.getDescription() + "\t"+ ticketIssue.getStatus());
		}
		}
		else
		{
			System.out.println("Incorrect user name or password");
		}
		
	}

}
