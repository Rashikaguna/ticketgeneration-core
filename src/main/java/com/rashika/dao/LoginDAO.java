package com.rashika.dao;

import com.rashika.exception.PersistanceException;

public class LoginDAO {

	UserInformationDAO userInformationDAO=new UserInformationDAO();
	public boolean login(String emailId,String password){
		String s=userInformationDAO.findOne(emailId).getPassword();
		if(s.equals(password))
			return true;
		return false;
	}
	
public boolean employeeLogin(String emailId,String password) throws PersistanceException  {
		EmployeeDAO employeeDAO=new EmployeeDAO();
		employeeDAO.findOne(emailId,password).getId();
						return true;
	
	
}

	
}
