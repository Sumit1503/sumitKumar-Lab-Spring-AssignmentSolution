package com.collegefest.library.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.collegefest.library.entity.Student;
import com.collegefest.library.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentsController {
	

	@Autowired
	private StudentService studentService;



	// add mapping for "/list"

	@RequestMapping("/list")
	public String listBooks(Model theModel) {
		

		// get students from db
		List<Student> students = studentService.findAll();

		// add to the spring model
		theModel.addAttribute("students", students);
		return "list-Students";
	}

	@RequestMapping("/addStudent")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Student theStudent = new Student();

		theModel.addAttribute("student", theStudent);

		return "StudentForm";
	}

	
	@RequestMapping("/updateStudent")
	public String showFormForUpdate(@RequestParam("studentId") Integer theId,
			Model theModel) {

		// get the student from the service
		Student theStudent = studentService.findById(theId);


		// set student as a model attribute to pre-populate the form
		theModel.addAttribute("student", theStudent);

		// send over to our form
		return "StudentForm";			
	}


	@PostMapping("/save")
	public String saveBook(@RequestParam("studentId") Integer id,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("course") String course,
			@RequestParam("country") String country) {

		System.out.println(id);
		Student theStudent;
		if(id!= null)
		{
			theStudent=studentService.findById(id);
			theStudent.setFirstName(firstName);
			theStudent.setLastName(lastName);
			theStudent.setCourse(course);
			theStudent.setCountry(country);
		}
		else
			theStudent=new Student(firstName,lastName,course,country);
		// save the student
		studentService.save(theStudent);


		// use a redirect to prevent duplicate submissions
		return "redirect:/students/list";

	}

	

	@RequestMapping("/deleteStudent")
	public String delete(@RequestParam("studentId") Integer theId) {

		if(theId!=0)
		{
			Student theStudent=studentService.findById(theId);
			studentService.delete(theStudent);
		}
		
		// redirect to /students/list
		return "redirect:/students/list";

	}



	
	@RequestMapping("/403")
	public ModelAndView accessDenied(Principal user)
	{
		ModelAndView mv=new ModelAndView();
		
		if(user!=null)
		{
			mv.addObject("msg", "Hi "+user.getName()+", you are not allowed to access this page");			
		}
		else
		{
			mv.addObject("msg", "Hi, you are not allowed to access this page");	
		}
		mv.setViewName("403");
		return mv;
	}

}
