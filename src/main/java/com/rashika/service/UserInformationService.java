package com.rashika.service;

import com.rashika.dao.LoginDAO;
import com.rashika.dao.UserInformationDAO;
import com.rashika.exception.PersistanceException;
import com.rashika.exception.ServiceException;
import com.rashika.exception.ValidatorException;
import com.rashika.model.UserInformation;
import com.rashika.validator.UserInformationValidator;

public class UserInformationService {
	private UserInformationDAO userInformationDAO = new UserInformationDAO();
	private LoginDAO loginDAO=new LoginDAO();
	UserInformation userInformation=new UserInformation();

	public void register(String name,String emailid,String password) throws ServiceException {

		try {

			UserInformationValidator.validatateForRegistration(name,emailid,password);
                   userInformationDAO.save(userInformation);
			} 
			

		catch (ValidatorException e) {
			throw new ServiceException("Unable to register", e);
		}
	}
	public boolean login(String emailid,String password) throws ServiceException  {

		try {

			UserInformationValidator.validatateForLogin(emailid,password);
			loginDAO.login(emailid, password);
			
			return true;

		} catch (ValidatorException e) {
			throw new ServiceException("Unable to insert customer", e);
		
		} 
	}
	
	
}