package com.practice.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long class_id;
    private String name;

    @OneToOne(mappedBy = "classroom")
    @JsonManagedReference 
    private Teacher teacher;

    @OneToMany(mappedBy = "classroom", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference 
    private List<Student> studentlist = new ArrayList<>();
    
    public Classroom() {
		// TODO Auto-generated constructor stub
	}

	public Classroom(long class_id, String name, Teacher teacher, List<Student> studentlist) {
		super();
		this.class_id = class_id;
		this.name = name;
		this.teacher = teacher;
		this.studentlist = studentlist;
	}

	public long getClass_id() {
		return class_id;
	}

	public void setClass_id(long class_id) {
		this.class_id = class_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Student> getStudentlist() {
		return studentlist;
	}

	public void setStudentlist(List<Student> studentlist) {
		this.studentlist = studentlist;
	}

	@Override
	public String toString() {
		return "Classroom [class_id=" + class_id + ", name=" + name + ", teacher=" + teacher + ", studentlist="
				+ studentlist + "]";
	}
    
    
}
