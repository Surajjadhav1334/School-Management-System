package com.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.entity.Classroom;
import com.practice.service.ClassroomService;

@RestController
@RequestMapping("/classroom")
public class ClassroomController {

	@Autowired
	ClassroomService classroomService;
	
	@PostMapping("/createclassroom")
	public Classroom createClassroom(@RequestBody Classroom classroom)
	{
		return classroomService.createClassroom(classroom);
	}
}
