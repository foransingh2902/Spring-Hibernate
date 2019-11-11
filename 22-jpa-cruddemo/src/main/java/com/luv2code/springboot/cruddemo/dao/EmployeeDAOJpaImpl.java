package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entiy.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		// create a query
		Query theQuery = entityManager.createQuery("from Employee");

		// execute query and get result list
		List<Employee> employees = theQuery.getResultList();

		// return the results
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		// get employee
		Employee theEmployee = entityManager.find(Employee.class, theId);
		// return employee
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		// save or update the employee. If id==0 then insert/save else update
		// will return the updated Employee for us.
		Employee dbEmployee = entityManager.merge(theEmployee);

		// update with id from db... so we can get generated id for save/insert
		// this will be used by our rest api to returning the generated ID.
		// This is considered good practice based on your app requirements. That is if
		// you want to see the updated database ID in the response. But it is not
		// mandatory.
		theEmployee.setId(dbEmployee.getId());

	}

	@Override
	public void deleteById(int theId) {
		// delete object with primary key
		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();

	}

}
