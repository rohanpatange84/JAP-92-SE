package com.model;

public class Student {
	private int id;
	private String name;
	private double mark;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, double mark) {
		super();
		if(isValidStudent( id,  name,mark)) {
		this.id = id;
		this.name = name;
		this.mark = mark;
		}
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

	public double getMark() {
		return mark;
	}

	public void setMark(double mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mark=" + mark + "]";
	}
	
	
	private boolean isValidStudent(int id, String name, double mark) {
		if (id < 0)
			throw new IllegalArgumentException("Not Valid " + id);
		{

		}
		if (name.equals("") || name.equals(null) || name.isEmpty()) {
			throw new IllegalArgumentException("In Valid Name" + name);
		}
		if (mark <= 0 || mark > 100) {
			throw new IllegalArgumentException("In Valid Marks" + mark);
		}

		return true;

	}

}
