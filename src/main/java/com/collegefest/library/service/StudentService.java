package com.collegefest.library.service;

import java.util.List;

import com.collegefest.library.entity.Student;

public interface StudentService {
	
	public List<Student> findAll();
	public void save(Student student);
	public Student findById(Integer id);
	public void delete(Student student);
	public List<Student> findByFirstName(String firstName, String lastName);

}
