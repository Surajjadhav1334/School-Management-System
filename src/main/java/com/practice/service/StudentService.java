package com.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.practice.dao.StudentDao;
import com.practice.entity.Student;

@Service
public class StudentService {
	
	@Autowired
	StudentDao studentDao;
	
	public Student addStudent(@RequestBody Student student)
	{
		return studentDao.save(student);
	}
	
	public List<Student> getallstudents()
	{
		return studentDao.findAll();
	}

}
