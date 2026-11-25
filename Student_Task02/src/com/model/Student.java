package com.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Student implements Serializable {

	private int id;
	private String name;
	private double marks;
	private LocalDate admissionDate;
	private LocalTime admissionTime;

	public Student() {

	}

	public Student(String name, double marks, LocalDate admissionDate,LocalTime admissionTime) {
      
        
        this.name = name;
        this.marks = marks;
        this.admissionDate = admissionDate;
        this.admissionTime = admissionTime;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public LocalDate getAdmissionDate() {
		return admissionDate;
	}
	
	public LocalTime getAdmissionTime() {
		return admissionTime;
	}

	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}
	
	public void setAdmissionTime(LocalTime admissionTime) {
		this.admissionTime = admissionTime;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", marks=" + marks + ", admissionDate=" + admissionDate
				+ ", admissionTime=" + admissionTime + "]";
	}

	
}
