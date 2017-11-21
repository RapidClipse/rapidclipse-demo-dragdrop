
package com.company.rapidclipse.demo.dragdrop.dal;

import com.xdev.dal.JPADAO;
import com.company.rapidclipse.demo.dragdrop.entities.Employee;

/**
 * Home object for domain model class Employee.
 * 
 * @see Employee
 */
public class EmployeeDAO extends JPADAO<Employee, Integer> {
	public EmployeeDAO() {
		super(Employee.class);
	}
}