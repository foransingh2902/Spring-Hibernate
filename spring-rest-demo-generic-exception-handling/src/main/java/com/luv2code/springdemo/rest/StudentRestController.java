package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
		// check the studentId against list size
		if ((studentId >= theStudents.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Student id not found- " + studentId);
		}
		return theStudents.get(studentId);
	}

	// Add an exception handler using @ExceptionHandler
	@ExceptionHandler // this tells its an exception handler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exe) {
		// Response entity is basically a wrapper around the response, so it provide a
		// fine grain control
		// over the response sent to the user
		// this method will only catch StudentNotFoundException as given in arguments

		// create a StudentErrorRespnse
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exe.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		// return ResponseEntity
		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.NOT_FOUND);
	}

	// add another exception handler.. to catch any exception (catch all)
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exe) {
		// create a StudentErrorRespnse
		StudentErrorResponse error = new StudentErrorResponse();
		// 400 error- BAD_REQUEST
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exe.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		// return ResponseEntity
		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}
}
