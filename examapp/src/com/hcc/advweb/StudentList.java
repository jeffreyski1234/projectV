package com.hcc.advweb;

import java.util.ArrayList;

public class StudentList {
	
	private static ArrayList<Student> studentList = null;

	public static ArrayList<Student> getStudentList() {
		if ((studentList == null) || (studentList.size() == 0)) {
			
			studentList = new ArrayList<Student>();
		
		}
		System.out.println("Student List ---->"+studentList);
		for (Student st:studentList) {
			System.out.println(st.getId() + st.getFirstName() + st.getLastName() + st.getAddress());
		}
		return studentList;
	}
	public static void setStudentsList(ArrayList<Student> studentList) {
		StudentList.studentList = studentList;
	}

	public static ArrayList<Student> addStudent(Student student) {
		getStudentList().add(student);
		return studentList;
	}
	
	public static ArrayList<Student> removeStudent(Student student) {
		getStudentList().remove(student);
		return studentList;
	}
	
	public static int getIndexById(String stID) {
		int ind = -1;
		for(int i=0;i<studentList.size();i++)
		{
			Student s = studentList.get(i);
			if( Integer.toString(s.getId()).equals(stID))
			{
				return i;
			}
		}
		return ind;
	}

	public StudentList() {
		// TODO Auto-generated constructor stub
	}}
