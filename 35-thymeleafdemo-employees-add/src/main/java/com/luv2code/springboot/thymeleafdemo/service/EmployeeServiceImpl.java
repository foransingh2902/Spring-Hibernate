package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;

//@Transactional - handles transaction management. So we don't have to manually start and commit
//transaction
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}

	// removed@Transactional since JpaRepository provides this functionality
	@Override
	public Employee findById(int theId) {
		// earlier :
		// return employeeRepository.findById(theId);
		// now :
		Optional<Employee> result = employeeRepository.findById(theId);
		Employee theEmployee = null;
		if (result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id -" + theId);

		}
		return theEmployee;
	}
	@Override
	public List<Employee> findAll() {
		// return employeeRepository.findAll();
		// Call our new method
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);

	}

}
