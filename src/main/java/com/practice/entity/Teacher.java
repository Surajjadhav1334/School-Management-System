package com.practice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long teacher_id;
    private String name;
    private String email;

    @OneToOne
    @JoinColumn(name = "class_id")
    @JsonBackReference // Prevents infinite recursion during JSON serialization
    private Classroom classroom;
    
    public Teacher() {
		// TODO Auto-generated constructor stub
	}

	public Teacher(long teacher_id, String name, String email, Classroom classroom) {
		super();
		this.teacher_id = teacher_id;
		this.name = name;
		this.email = email;
		this.classroom = classroom;
	}

	public long getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(long teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	@Override
	public String toString() {
		return "Teacher [teacher_id=" + teacher_id + ", name=" + name + ", email=" + email + ", classroom=" + classroom
				+ "]";
	}
    
    
}
