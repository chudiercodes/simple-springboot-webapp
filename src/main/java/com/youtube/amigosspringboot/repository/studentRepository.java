package com.youtube.amigosspringboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youtube.amigosspringboot.model.Student;

@Repository
public interface studentRepository extends JpaRepository<Student, Long> {
    
    Optional<Student> findStudentByEmail(String email);
}