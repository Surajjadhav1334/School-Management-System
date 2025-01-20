package com.practice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.entity.Classroom;

@Repository
public interface Classroomdao extends JpaRepository<Classroom, Long> {
	
//	public String createClassroom(Classroom classroom);
}
