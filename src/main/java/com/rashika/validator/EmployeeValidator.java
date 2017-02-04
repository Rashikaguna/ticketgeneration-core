package com.rashika.validator;

import com.rashika.exception.ValidatorException;
import com.rashika.model.Employee;
import com.rashika.util.Validator;

public class EmployeeValidator {

	Validator validator=new Validator();
	public void save(Employee employee) throws ValidatorException{
		validator.isInvalid(employee.getName(), "NAME");
		validator.isInvalid(employee.getEmailId(),"EMAILID");
		validator.isInvalid(employee.getPassword(),"PASSWORD");
}

}