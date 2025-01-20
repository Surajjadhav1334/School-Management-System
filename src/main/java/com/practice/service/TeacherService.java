package com.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.practice.dao.TeacherDao;
import com.practice.entity.Teacher;

@Service
public class TeacherService {

	@Autowired
	TeacherDao teacherDao;
	
	public Teacher addteacher( Teacher teacher)
	{
		return teacherDao.save(teacher);
	}
}
