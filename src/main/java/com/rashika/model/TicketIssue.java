package com.rashika.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TicketIssue {

	private int id;
	private UserInformation userId;
	private String subject;
	private String description;
	private Department departmentId;
	private String priority;
    private LocalDateTime createdDate;
	private LocalDate resolvedDate;
	private String status;
	
}