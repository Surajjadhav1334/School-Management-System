package com.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.entity.Teacher;
import com.practice.service.TeacherService;

import lombok.Getter;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	TeacherService teacherService;
	
	@PostMapping("/add-teacher")
	public Teacher addteacher(@RequestBody Teacher teacher)
	{
		return teacherService.addteacher(teacher);
	}
	
	@GetMapping("/getallteacher")
	public List<Teacher> getallteacher()
	{
		return teacherService.getallteacher();
	}

}
