package com.rashika.validator;

import com.rashika.exception.ValidatorException;
import com.rashika.model.Employee;
import com.rashika.util.Validator;

public class EmployeeValidator {

	Validator validator=new Validator();
	public void save(Employee employee) throws ValidatorException{
		Validator.isInvalid(employee.getName(), "NAME");
		Validator.isInvalid(employee.getEmailId(),"EMAILID");
		Validator.isInvalid(employee.getPassword(),"PASSWORD");
}

}