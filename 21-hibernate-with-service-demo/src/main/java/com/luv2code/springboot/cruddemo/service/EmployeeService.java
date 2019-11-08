package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import com.luv2code.springboot.cruddemo.entiy.Employee;

public interface EmployeeService {
	public Employee findById(int theId);

	public List<Employee> findAll();

	public void save(Employee theEmployee);

	public void deleteById(int theId);
}
