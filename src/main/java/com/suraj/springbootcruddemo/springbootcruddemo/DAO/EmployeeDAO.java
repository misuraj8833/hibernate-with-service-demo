package com.suraj.springbootcruddemo.springbootcruddemo.DAO;

import java.util.List;

import com.suraj.springbootcruddemo.springbootcruddemo.entity.Employee;

public interface EmployeeDAO 
{
	
	public List<Employee> getAllEmployee();
	public Employee findbyId(int Id);
	public void save(Employee theEmployee);
	public void deleteById(int Id);

}
