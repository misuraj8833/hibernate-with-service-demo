package com.suraj.springbootcruddemo.springbootcruddemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.suraj.springbootcruddemo.springbootcruddemo.entity.Employee;
import com.suraj.springbootcruddemo.springbootcruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController 
{
	
	//inject the EmployeeService 
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployees()
	{
		return employeeService.getAllEmployee();
	}

	@GetMapping("/employees/{Id}")
	public Employee findbyId (@PathVariable int Id)
	{
		Employee employee = employeeService.findbyId(Id);
		if (employee == null)
			throw new RuntimeException("Employee id not found - "+Id);
		return employee;
	}
	
	@PostMapping("/employees")
	public Employee save(@RequestBody Employee theEmployee) {
		
		//also just in case they pass an id in JSON... set id to 0
		//this is to force a save of new item...instead of update
		
		theEmployee.setId(0);
		
		employeeService.save(theEmployee);
		
		return theEmployee;
	}
	
	@DeleteMapping("/employees/{Id}")
	public void delete(@PathVariable  int Id)
	{
		try{
			employeeService.deleteById(Id);
		}
		catch (Exception e){
			throw new RuntimeException("The Employee id not found-"+Id);
		}

	}
	
}
