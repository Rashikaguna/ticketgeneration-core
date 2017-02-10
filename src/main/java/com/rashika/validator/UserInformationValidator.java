package com.rashika.validator;

import com.rashika.exception.ValidatorException;
import com.rashika.model.UserInformation;
import com.rashika.util.Validator;

public class UserInformationValidator {
	Validator validator=new Validator();
	public void save(UserInformation user) throws ValidatorException{
		Validator.isInvalid(user.getName(), "NAME");
		Validator.isInvalid(user.getEmailId(),"EMAILID");
		Validator.isInvalid(user.getPassword(), "PASSWORD");

}
}