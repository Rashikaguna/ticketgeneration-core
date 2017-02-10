package com.rashika.dao;

import com.rashika.model.UserInformation;

public class TestUserInformationDAO {

	public static void main(String[] args) {
UserInformation userInformation=new UserInformation();
UserInformationDAO us=new UserInformationDAO();
userInformation.setEmailId("rashika@gmail.com");
userInformation.setPassword("rashika12");
System.out.println(us.find1(userInformation.getEmailId(),userInformation.getPassword()));
//		final List<UserInformation> list = userInformationDAO.listuserinformation();
//      final Iterator<UserInformation> ii = list.iterator();
//      
//      while (ii.hasNext()) {
//			final UserInformation userInformation = (UserInformation) ii.next();
//          System.out.println(userInformation.getId()+"\t"+userInformation.getName()+"\t"+userInformation.getEmailId()+"\t"+userInformation.getPassword()+"\t"+userInformation.isActive());
      }	

	}


