package com.practice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.entity.Classroom;
import com.practice.entity.Teacher;
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
	
	@GetMapping("/all-classroom")
	public List<Classroom> getallclassroom()
	{
		return classroomService.getallclassroom();
		
	}
	
	@GetMapping("/classroom-id/{id}")
	public Optional<Classroom> getclassbyid(@PathVariable("id") long id)
	{
		return classroomService.getclassbyid(id);
	}
	
	@PatchMapping("/{class_id}/assign_teacher/{teacher_id}")
	public ResponseEntity<String> assignteacher(@PathVariable("class_id") long class_id, @PathVariable long teacher_id )
	{
		 String result = classroomService.assignteacher(class_id, teacher_id);
		 System.out.println(result);
		   if (result.equals("Teacher assigned successfully.")) {
	            return ResponseEntity.ok(result);
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
	        }
	}
	
	@PatchMapping("/{class_id}/assign_student/{student_id}")
	public ResponseEntity<String> assignstudent(@PathVariable long class_id, @PathVariable long student_id)
	{
		String result = classroomService.assignstudent(class_id, student_id);
		
		if (result.equals("Student assigned successfsully.")) {
			return ResponseEntity.ok(result);
		}
		else
		{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
		}
	}
	
	@DeleteMapping("/deleteclassroom/{id}")
	public String deleteclassroom(@PathVariable("id") long class_id)
	{
		return classroomService.deleteclassroom(class_id);
	}
}
