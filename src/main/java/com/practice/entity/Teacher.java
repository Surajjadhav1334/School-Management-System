package com.practice.entity;

import javax.persistence.CascadeType;
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
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	long teacher_id;
	String name;
	String email;
	
	@OneToOne( mappedBy = "teacher")
	@JsonBackReference
	Classroom classroom;
	

}
