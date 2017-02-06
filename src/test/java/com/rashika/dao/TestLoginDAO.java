package com.rashika.dao;

import com.rashika.exception.PersistanceException;

public class TestLoginDAO {

	public static void main(String[] args) throws PersistanceException {
LoginDAO loginDAO=new LoginDAO();
System.out.println(loginDAO.employeeLogin("roshni@gmail.com","roshni12"));
	}

}
