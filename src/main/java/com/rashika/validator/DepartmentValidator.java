package com.rashika.validator;

import com.rashika.exception.ValidatorException;
import com.rashika.model.Department;
import com.rashika.util.Validator;

public class DepartmentValidator {

	Validator validator=new Validator();
	public void save(Department department) throws ValidatorException{
		Validator.isInvalid(department.getDepartment(),"DEPARTMENT");
}
}