package com.rashika.util;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
public class MailUtil {
	
	private  MailUtil() {
	}


	
	public static void sendSimpleMail() throws EmailException{
	Email email = new SimpleEmail();

	email.setSmtpPort(465);
	
	email.setAuthenticator(new DefaultAuthenticator("ticketms12@gmail.com", "ticket12"));
	email.setDebug(false);
	email.setHostName("smtp.gmail.com");
	email.setSSLOnConnect(true);
	email.setFrom("ticketms12@gmail.com");
	email.setSubject("TicketGenerated");
	email.setMsg("Hello, a ticket has been created by a user");
	email.addTo("reginajohn1995@gmail.com");
	email.setStartTLSEnabled(true);
	email.send();
	
		
	}
}
