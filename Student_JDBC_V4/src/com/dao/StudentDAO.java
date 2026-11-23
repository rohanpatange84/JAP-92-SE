package com.dao;

import java.util.List;

import com.model.Student;

public interface StudentDAO {
	
	void addStudent(Student s1);

	void deleteStudent(int id);

	void updateStudent(int id, String name, double marks);

	void readStudent();
	
	void addAllStudent(List<Student> list);
	
	Student findStudentById(int id) ;
	
	void findAllNames();
	
	void findIdAndName();
	
	void findIdAndMark();

}
