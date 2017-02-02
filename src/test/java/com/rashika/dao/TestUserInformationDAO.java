package com.rashika.dao;


import java.util.Iterator;
import java.util.List;

import com.rashika.model.UserInformation;

public class TestUserInformationDAO {

	public static void main(String[] args) {
//UserInformation userInformation=new UserInformation();
UserInformationDAO userInformationDAO=new UserInformationDAO();
//userInformation.setEmailId("solai@gmail.com");
//userInformation.setPassword("solai1234");
//userInformationDAO.delete(4);

		final List<UserInformation> list = userInformationDAO.listuserinformation();
      final Iterator<UserInformation> ii = list.iterator();
      
      while (ii.hasNext()) {
			final UserInformation userInformation = (UserInformation) ii.next();
          System.out.println(userInformation.getId()+"\t"+userInformation.getName()+"\t"+userInformation.getEmailId()+"\t"+userInformation.getPassword()+"\t"+userInformation.isActive());
      }	

	}

}
