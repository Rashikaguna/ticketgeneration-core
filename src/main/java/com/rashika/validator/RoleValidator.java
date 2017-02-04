package com.rashika.validator;

import com.rashika.exception.ValidatorException;
import com.rashika.model.Role;
import com.rashika.util.Validator;

public class RoleValidator {

	Validator validator=new Validator();
	public void save(Role role) throws ValidatorException{
		validator.isInvalid(role.getRole(), "NAME");
}
}