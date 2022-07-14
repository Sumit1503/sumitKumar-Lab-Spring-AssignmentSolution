package com.collegefest.library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collegefest.library.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	public List<Student> findByFirstNameContainsAndLastNameContainsAllIgnoreCase(String firstName, String lastName);

}
