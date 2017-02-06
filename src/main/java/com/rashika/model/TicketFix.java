package com.rashika.model;

import lombok.Data;

@Data
public class TicketFix {
private int id;
private Employee empId;
private TicketIssue ticketId;
private String solution;
}
