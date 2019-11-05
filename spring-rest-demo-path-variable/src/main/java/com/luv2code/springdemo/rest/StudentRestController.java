package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	private List<Student> theStudents;

	// define @PostConstruct to load the student data ... only once!
	/*
	 * The @PostConstruct annotation is used on a method that needs to be executed
	 * after dependency injection is done to perform any initialization.
	 * The @PreDestroy annotation is used on methods as a callback notification to
	 * signal that the instance is in the process of being removed by the container.
	 */
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<Student>();
		theStudents.add(new Student("foran", "singh"));
		theStudents.add(new Student("gaurav", "mittal"));
		theStudents.add(new Student("dilpreet", "singh"));
		// this will load student data only once
	}

	// define end point for "/students" -return list of students
	@GetMapping("/students")
	public List<Student> getStudents() {


		return theStudents;
	}
	// define end point for "/students/{studentId}" - return student at index
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		// just index into the list..
		return theStudents.get(studentId);
	}
}
