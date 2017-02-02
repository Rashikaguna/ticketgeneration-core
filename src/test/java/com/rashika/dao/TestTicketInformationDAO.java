package com.rashika.dao;

import java.util.Iterator;
import java.util.List;

import com.rashika.model.TicketInformation;

public class TestTicketInformationDAO {

	public static void main(String[] args) {
	TicketInformationDAO ticketInformationDAO=new TicketInformationDAO();
	
		List<TicketInformation> list =ticketInformationDAO.listticket();
		Iterator i = list.iterator();
		while (i.hasNext()) {
		TicketInformation ticketInformation=(TicketInformation) i.next();
		System.out.println(ticketInformation.getId() + "\t" +ticketInformation.getUserId()+ "\t" +ticketInformation.getSubject()+ "\t" +ticketInformation.getDescription()+ "\t" +ticketInformation.getCreatedDate()+ "\t" +ticketInformation.getDeptId()+ "\t" +ticketInformation.getEmpId()+ "\t" +ticketInformation.getResolvedDate()+ "\t" +ticketInformation.getStatus());

	}
	}
}
