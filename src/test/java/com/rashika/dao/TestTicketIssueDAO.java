package com.rashika.dao;

import com.rashika.model.TicketIssue;
import com.rashika.model.UserInformation;

public class TestTicketIssueDAO {

	public static void main(String[] args) {
		TicketIssueDAO ticketIssueDAO=new TicketIssueDAO();
		TicketIssue ticketIssue=new TicketIssue();

		UserInformation u=new UserInformation();
		u.setId(1);
		ticketIssue.setUserId(u);
ticketIssue.setId(17);
//		ticketIssueDAO.updateClose(ticketIssue);
		
		//System.out.println(ticketIssueDAO.getStatus(11));
		
		System.out.println(ticketIssueDAO.findempTickets(1));
		
		
		UserInformation userInformation=new UserInformation();
		userInformation.setId(2);
		ticketIssue.setUserId(userInformation);
		ticketIssue.setId(10);
		ticketIssueDAO.findStatus(ticketIssue.getUserId().getId(), ticketIssue.getId());
//		Department department=new Department();
//		department.setId(1);
//		ticketIssue.setDepartmentId(department);
//		
//		ticketIssue.setSubject("pay check");
//		ticketIssue.setDescription("Bill is not generated lko");
//		ticketIssueDAO.updateDescription(ticketIssue);
//		ticketIssue.setPriority("high");
//		
//		ticketIssueDAO.save(ticketIssue);        
//		List<TicketIssue> list = ticketIssueDAO.findAll();
//		Iterator i = list.iterator();
//		while (i.hasNext()) {
//			TicketIssue ticketIssue2 = (TicketIssue) i.next();
//			System.out.println(ticketIssue2.getId()+"\t"+ ticketIssue2.getUserId().getId()
//					+"\t"+ticketIssue2+"\t"+ticketIssue2.getSubject()
//					+"\t"+ticketIssue2.getDescription()+"\t"+ticketIssue2.getDepartmentId().getId()
//					+"\t"+ticketIssue2.getPriority()+"\t"+ticketIssue2.getCreatedDate()
//					+"\t"+ticketIssue2.getResolvedDate()+"\t"+ticketIssue2.getStatus());
//		}
	//	System.out.println(ticketIssueDAO.findStatus(2, 2).getStatus());
	}

}