package com.suraj.springbootcruddemo.springbootcruddemo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.suraj.springbootcruddemo.springbootcruddemo.DAO.EmployeeDAO;
import com.suraj.springbootcruddemo.springbootcruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	
	//inject the EmployeeDAO interface
	private EmployeeDAO employeeDAO;
	
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	
	@Override
	@Transactional
	public List<Employee> getAllEmployee() {
		
		return employeeDAO.getAllEmployee();
	}

	@Override
	@Transactional
	public Employee findbyId(int Id) {
		return employeeDAO.findbyId(Id);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		employeeDAO.save(theEmployee);
		
	}

	@Override
	@Transactional
	public void deleteById(int Id) {
		employeeDAO.deleteById(Id);
		
	}
	
	
	
	

}
