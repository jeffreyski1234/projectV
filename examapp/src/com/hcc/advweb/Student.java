package com.hcc.advweb;

public class Student {
	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Student(int i, String f,String l, String a, String c) {
		id = i;
		firstName = f;
		lastName = l;
		address = a;
		city = c;
	}
	public Student(int i, String f,String l, String c) {
		id = i;
		firstName = f;
		lastName = l;
		address = "none";
		city = c;
	}
	public Student(int id, String fname, String lname) {
		setId(id);
		setFirstName(fname);
		setLastName(lname);		
	}

	
}
