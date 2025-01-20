package com.practice.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Classroom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long class_id;
	String name;
	
	@OneToOne  
	@JsonManagedReference
	Teacher teacher;
	
	@OneToMany( mappedBy = "classroom", fetch = FetchType.LAZY)
	@JsonManagedReference
	List<Student> studentlist= new ArrayList<Student>();

}
