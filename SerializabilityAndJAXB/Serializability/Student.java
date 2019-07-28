package com.accolite.au.serializable;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Student extends Person implements Serializable{

	int studentId;
	int standard;
	String division;
	transient int mark;
	Address address;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getStandard() {
		return standard;
	}
	public void setStandard(int standard) {
		this.standard = standard;
	}
	
	
	public Student() {
		
	}
	public Student(String firstName,String lastName,int studentId, int standard, String division, int mark, Address address) {
		super(firstName,lastName);
		this.studentId = studentId;
		this.standard = standard;
		this.division = division;
		this.mark = mark;
		this.address = address;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString()
	{
		return "STUDENT DETAILS:\n First Name:"+firstName+"\n Last Name:"+lastName+"\n Student Id:"+studentId+"\n Standard:"+standard+"\n Division:"+division+"\n Mark:"+mark+"\n Address:"+address.city+" "+address.state+" "+address.state+" "+address.zip;
	}
}



