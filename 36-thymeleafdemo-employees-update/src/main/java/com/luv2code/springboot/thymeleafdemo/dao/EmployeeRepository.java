package com.luv2code.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

// <Entity type, Primary key>
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	// no need to write any code!!!!!!!!
	// all the CRUD methods will be provided for free
	public List<Employee> findAllByOrderByLastNameAsc();
	/*
	 * findAllBy-- part of a pattern
	 * 
	 * OrderByLastNameAsc
	 * 
	 * "from Employee order by lastName asc"
	 * 
	 * Spring Data JPA!!!
	 */
	// order by last name ascending
	// Spring Data JPA will parse the method name
	// Looks for a specific format and pattern
	// Create appropriate query.. behind the scenes
}
