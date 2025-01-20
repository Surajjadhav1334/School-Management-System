package com.practice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.entity.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Long> {
	

}
