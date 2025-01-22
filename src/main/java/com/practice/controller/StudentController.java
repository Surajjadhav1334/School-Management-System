package com.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.entity.Student;
import com.practice.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/add-student")
	public Student addStudent(@RequestBody Student student)
	{
		return studentService.addStudent(student);
	}
	
	@GetMapping("/getallstudents")
	public List<Student> getallstudents()
	{
		return studentService.getallstudents();
	}

}
