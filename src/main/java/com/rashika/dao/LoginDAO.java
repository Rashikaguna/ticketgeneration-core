package com.rashika.dao;

import com.rashika.model.UserInformation;

public class LoginDAO {

	UserInformation userInformation=new UserInformation();
	UserInformationDAO userInformationDAO=new UserInformationDAO();
	public boolean login(String emailId,String password){
		String s=userInformationDAO.findOne(emailId).getPassword();
		if(s.equals(password))
			return true;
		return false;
	}
	
}
