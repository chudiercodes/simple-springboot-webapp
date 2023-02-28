package com.youtube.amigosspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.amigosspringboot.model.Student;
import com.youtube.amigosspringboot.repository.studentRepository;

import java.util.*;

import javax.transaction.Transactional;

@Service
public class studentService {
    
	private final studentRepository studRepository;

	@Autowired
    public studentService(studentRepository studRepository) {
		this.studRepository = studRepository;
	}

	public List<Student> getStudents() {
        return studRepository.findAll();
	}

	public void addNewStudent(Student student) {
		Optional<Student> studentByEmail = studRepository.findStudentByEmail(student.getEmail());

		if(studentByEmail.isPresent()) {
			throw new IllegalStateException("A student already exists with that email");
		}
		studRepository.save(student);
		System.out.println(student);
	}

	public Student getSingleStudent(long id) {
		return studRepository.findById(id).get();
	}

	public void deleteStudent(long id) {
		boolean exists = studRepository.existsById(id);

		if(!exists){
			throw new IllegalStateException("Student with id " + id + " does not exist");
		}
		studRepository.deleteById(id);
	}

	@Transactional
	public void updateStudent(long id, String name, String email) {
		Student student = studRepository.findById(id).orElseThrow(() -> new IllegalStateException("Student with id " + id + " does not exist"));

		if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
			student.setName(name);
		}
		if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
			Optional<Student> sOptional = studRepository.findStudentByEmail(email);
			
			if(sOptional.isPresent()) {
				throw new IllegalStateException("Email taken");
			}
			
			student.setEmail(email);
		}
	}

}