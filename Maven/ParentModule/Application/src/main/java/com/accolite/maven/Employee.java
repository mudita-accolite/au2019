package com.accolite.maven;
import java.util.*;
public class Employee implements Comparator<Employee>{

	private String name;
	private int id;
	private int salary;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Employee(String name, int id, int salary) {
		super();
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	@Override
	public String toString()
	{
		return name+" "+id+" "+salary;
	}
	public int compare(Employee e1, Employee e2) {
		 if(e1.getId()>e2.getId()) 
			  return 1; 
		  else if(e1.getId()<e2.getId()) 
			  return -1;
		  return 0;
	}
	
}
