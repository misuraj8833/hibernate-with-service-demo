package com.suraj.springbootcruddemo.springbootcruddemo.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.suraj.springbootcruddemo.springbootcruddemo.entity.Employee;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	//inject the EntityManager bean which is already created by spring boot in spring boot we have to use entity manager
	//this is same as sessionFactory in normal spring
	//this already has been initialized by the properties specified in application.properties file so it contains
	//jdbc url , username and password , we just need to inject the same.
	private EntityManager entityManager;
	
	//autowire the field using constructor injection.
	@Autowired
	public EmployeeDAOImpl(EntityManager theentityManager) {
		this.entityManager = theentityManager;
	}
	
	@Override
	public List<Employee> getAllEmployee() 
	{
		
		//get the new session we need to use the unwrap method to get the Session
		Session currentSession = entityManager.unwrap(Session.class);
		//create the query
		Query<Employee> employeeQuery = currentSession.createQuery("from Employee",Employee.class);
		//run the query and get the result
		List <Employee> employees = employeeQuery.getResultList();
		//return List<Employee>
		return employees;
	}

	@Override
	public Employee findbyId(int Id) {
		//get the session
		Session currentSession = entityManager.unwrap(Session.class);
		//create a query
		Employee employee = currentSession.get(Employee.class, Id );
		//return the result
		return employee;
	}

	@Override
	public void save(Employee theEmployee) {
		//get the session
		Session currentSession = entityManager.unwrap(Session.class);
		//create a query
		currentSession.saveOrUpdate(theEmployee);
	}

	@Override
	public void deleteById(int Id) {
		//get the session
		Session currentSession = entityManager.unwrap(Session.class);
		//create a query
		currentSession.delete(Id);
	}

}
