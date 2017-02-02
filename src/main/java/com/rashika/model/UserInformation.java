package com.rashika.model;

import lombok.Data;

@Data
public class UserInformation {
	private int id;
	private String name;
	private String emailId;
    private String password;
	private boolean isActive;


}
