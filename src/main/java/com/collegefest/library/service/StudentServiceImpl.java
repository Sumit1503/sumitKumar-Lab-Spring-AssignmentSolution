package com.collegefest.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegefest.library.entity.Student;
import com.collegefest.library.repositories.StudentRepository;



@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepo;
	
	

	@Override
	public List<Student> findAll() {	
		return studentRepo.findAll();
	}

	@Override
	public void save(Student student) {
		studentRepo.save(student);
		
	}

	@Override
	public Student findById(Integer id) {
		studentRepo.findById(id).get();
		return null;
	}

	@Override
	public void delete(Student student) {
		studentRepo.delete(student);
		
	}

	@Override
	public List<Student> findByFirstName(String firstName, String lastName) {
		
		return studentRepo.findByFirstNameContainsAndLastNameContainsAllIgnoreCase(firstName, lastName);
	}


}
