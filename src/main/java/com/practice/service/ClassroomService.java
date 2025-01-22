package com.practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.practice.dao.Classroomdao;
import com.practice.dao.StudentDao;
import com.practice.dao.TeacherDao;
import com.practice.entity.Classroom;
import com.practice.entity.Student;
import com.practice.entity.Teacher;

@Service
public class ClassroomService {
	
	@Autowired
	Classroomdao classroomdao;
	
	@Autowired
	TeacherDao teacherDao;
	
	@Autowired
	StudentDao studentDao;
	
	public Classroom createClassroom(Classroom classroom)
	{
		return classroomdao.save(classroom);
	}
	
	public List<Classroom> getallclassroom()
	{
		return classroomdao.findAll();
	}

	public Optional<Classroom> getclassbyid(long id)
	{
		return classroomdao.findById(id);
	}
	
    public String assignteacher(long class_id, long teacher_id) {
        Optional<Classroom> classroomOpt = classroomdao.findById(class_id);
        Optional<Teacher> teacherOpt = teacherDao.findById(teacher_id);

        if (classroomOpt.isPresent() && teacherOpt.isPresent()) {
            Classroom classroom = classroomOpt.get();
            Teacher teacher = teacherOpt.get();

//            classroom.setTeacher(teacher); 
//            classroomdao.save(classroom); 
            
            teacher.setClassroom(classroom);
            teacherDao.save(teacher);

            return "Teacher assigned successfully.";
        } else {
            return "Classroom or Teacher not found.";
        }
    }
    
    public String assignstudent(long class_id, long student_id)
    {
    	Optional<Classroom> classroom = classroomdao.findById(class_id);
    	Optional<Student> student = studentDao.findById(student_id);
    	
    	if (classroom.isPresent() && student.isPresent()) {
			Classroom classroom2 = classroom.get();
			Student student2 = student.get();
			
			student2.setClassroom(classroom2);
			studentDao.save(student2);
			
			 return "Student assigned successfsully.";
		}
    	else {
            return "Classroom or Student not found.";
        }
    }
    
    public String deleteclassroom(long class_id)
	{
		 if (classroomdao.existsById(class_id)) {
			classroomdao.deleteById(class_id);
			return "deleted";
		}
		 else
		 {
			 return "not found";
		 }
	}
}
