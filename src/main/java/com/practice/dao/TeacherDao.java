package com.practice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.entity.Teacher;

@Repository
public interface TeacherDao extends JpaRepository<Teacher, Long> {

}
