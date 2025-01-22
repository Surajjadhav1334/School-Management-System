package com.practice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long student_id;
    private String name;
    private int age;

    @ManyToOne
    @JsonBackReference // Prevents infinite recursion during JSON serialization
    private Classroom classroom;
    
    public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(long student_id, String name, int age, Classroom classroom) {
		super();
		this.student_id = student_id;
		this.name = name;
		this.age = age;
		this.classroom = classroom;
	}

	public long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(long student_id) {
		this.student_id = student_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", name=" + name + ", age=" + age + ", classroom=" + classroom
				+ "]";
	}
    
}

