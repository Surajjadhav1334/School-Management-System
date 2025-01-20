package com.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.practice.dao.Classroomdao;
import com.practice.entity.Classroom;

@Service
public class ClassroomService {
	
	@Autowired
	Classroomdao classroomdao;
	
	public Classroom createClassroom(Classroom classroom)
	{
		return classroomdao.save(classroom);
	}

}
