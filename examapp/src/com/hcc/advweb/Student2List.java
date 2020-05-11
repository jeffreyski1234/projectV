package com.hcc.advweb;

import java.util.ArrayList;

public class Student2List {

	private static ArrayList<Student2> studentsList = null;
	
	public static ArrayList<Student2> getStudentsList() {
		//if ((studentsList == null) && (studentsList.size() == 0)) {
			studentsList = new ArrayList<Student2>();
			studentsList.add(new Student2(1,"Raj","Joseph"));
			studentsList.add(new Student2(2,"Jose","Gonzales"));
			studentsList.add(new Student2(3,"Bob","Smith"));
			studentsList.add(new Student2(4,"Adrian","Shah"));
			studentsList.add(new Student2(5,"Kelly","Branco"));
		//}
		System.out.println("Student List ---->"+studentsList);
		return studentsList;
	}
	public static void setStudentsList(ArrayList<Student2> studentsList) {
		studentsList = studentsList;
	}

	

}
