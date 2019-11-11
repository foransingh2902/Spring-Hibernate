package com.luv2code.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.cruddemo.entiy.Employee;

// <Entity type, Primary key>
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	// no need to write any code!!!!!!!!
	// all the CRUD methods will be provided for free
}
