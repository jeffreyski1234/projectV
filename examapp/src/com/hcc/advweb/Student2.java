package com.hcc.advweb;

public class Student2 {

	private int id;
	private String fname;
	private String lname;
	private String phone;
	private String address1;
	private String address2;
	private String city;
	private String zip;
	private String state;
	private String country;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Student2() {
		// TODO Auto-generated constructor stub
	}
	
	public Student2(int id, String fname, String lname) {
		setId(id);
		setFname(fname);
		setLname(lname);		
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", fname=" + fname + ", lname=" + lname + ", phone=" + phone + ", address1="
				+ address1 + ", address2=" + address2 + ", city=" + city + ", zip=" + zip + ", state=" + state
				+ ", country=" + country + ", getId()=" + getId() + ", getFname()=" + getFname() + ", getLname()="
				+ getLname() + ", getPhone()=" + getPhone() + ", getAddress1()=" + getAddress1() + ", getAddress2()="
				+ getAddress2() + ", getCity()=" + getCity() + ", getZip()=" + getZip() + ", getState()=" + getState()
				+ ", getCountry()=" + getCountry() + "]";
	}
	
	

}
