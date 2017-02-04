package com.rashika.model;

import lombok.Data;

@Data
public class TicketFix {
private int id;
private TicketIssue ticketId;
private String solution;
}
