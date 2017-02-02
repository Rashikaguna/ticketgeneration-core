package com.rashika.model;

import com.rashika.model.UserInformation;

public class TestUserInformation {
	
	public static void main(String[] args) {
		UserInformation userInformation = new UserInformation();
		userInformation.setId(4);
		userInformation.setName("Solai");
		userInformation.setEmailId("solai@gmail.com");
		userInformation.setPassword("solai12");
		System.out.println(userInformation.getId()+""+userInformation.getName()+""+userInformation.getEmailId()+""+userInformation.getPassword());
		
		}
	
}
