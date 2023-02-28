package com.youtube.amigosspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.youtube.amigosspringboot.model.Student;
import com.youtube.amigosspringboot.service.studentService;

import java.util.*;;

@RestController
@RequestMapping(path = "/students")
public class studentController { 
	
	private final studentService studService;

	@Autowired
	public studentController(studentService studService) {
		this.studService = studService;
	};

	@GetMapping
	public List<Student> getStudents() {
		return studService.getStudents();
	};

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable long id) {
		Student student = studService.getSingleStudent(id);
		return ResponseEntity.status(200).body(student);
	}
	
	@PostMapping
	public void registerStudent(Student student) {
		studService.addNewStudent(student);
	};

	@DeleteMapping(path = "{id}")
	public void deleteStudent(@PathVariable("id") long id) {
		studService.deleteStudent(id);
	}

	@PutMapping(path = "{id}")
	public void updateStudent(@PathVariable("id") long id, @RequestParam(required = false) String name, @RequestParam(required = false) String email) {
		studService.updateStudent(id, name, email);
	}
}