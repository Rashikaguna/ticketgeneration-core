package com.rashika.model;

import lombok.Data;

@Data
public class Employee {
	private int id;
	private String name;
	private Department deptId;
	private Role roleId;
	private String emailId;
    private String password;
	private boolean isActive;

}
