package com.rashika.dao;



import com.rashika.model.TicketFix;
import com.rashika.model.TicketIssue;
import com.rashika.dao.TicketFixDAO;


public class TestTicketFixDAO {

	public static void main(String[] args) {
		TicketFixDAO ticketFixDAO=new TicketFixDAO();

		TicketFix ticketFix=new TicketFix();
		ticketFix.setId(2);
		TicketIssue ticketIssue=new TicketIssue();
		ticketIssue.setId(3);
		ticketFix.setTicketId(ticketIssue);
		ticketFix.setSolution("Updates the user");
		ticketFixDAO.save(ticketFix);
		// IssuesSolutions issue = new IssuesSolutions();
//		List<TicketFix> list = ticketFixDAO.listAll();
//		Iterator<TicketFix> i = list.iterator();
//		while (i.hasNext()) {
//			TicketFix tt1 = (TicketFix) i.next();
//			System.out.println(tt1.getId() + "\t" + tt1.getTicketId().getId() + "\t" + tt1.getSolution());
//
//		}
	}

}