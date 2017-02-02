package com.rashika.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TicketInformation {
private int id;
private UserInformation userId;
private String subject;
private String Description;
private LocalDateTime createdDate;
private Department deptId;
private Employee empId;
private LocalDateTime resolvedDate;
private String status;



}
