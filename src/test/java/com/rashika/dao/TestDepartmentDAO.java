package com.rashika.dao;


public class TestDepartmentDAO {

	public static void main(String[] args) {
DepartmentDAO departmentDAO=new DepartmentDAO();
   

 System.out.println(departmentDAO.findId("HUMAN RESOURCE").getId());
//departmentDAO.delete(4);
//final List<Department> list = departmentDAO.listdept();
//final Iterator<Department> ii = list.iterator();
//
//while (ii.hasNext()) {
//		final Department department = (Department) ii.next();
//    System.out.println(department.getId()+"\t"+department.getDepartment()+"\t"+department.isActive());
//}	

	}

}
