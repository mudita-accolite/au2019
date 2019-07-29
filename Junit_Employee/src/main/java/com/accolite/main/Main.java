package com.accolite.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.accolite.pojo.Employee;
import com.accolite.pojo.ListEmployee;

//delete 
//get all employess(list)
//find by id 
//update emp

public class Main {

	public static void main(String[] args) {

	}
	static ListEmployee le=new ListEmployee();
	
	public boolean isListEmpty()
	{
		List<Employee> employees=le.getEmpList();
		if(employees==null) 
		{	
			throw new NullPointerException();
		}
		else
			return false;
	}
	
	public Employee addEmployee(Employee emp)
	{
		List<Employee> employees=le.getEmpList();
		if(employees==null) {
			employees=new ArrayList<Employee>();
		}
		employees.add(emp);
		le.setEmpList(employees);
		return emp;
	}
	
	public boolean ListEmployee()
	{
			List<Employee> employees=le.getEmpList();
			for(Employee em:employees)
			{
				System.out.println(em.getEmpName()+" "+em.getEmpId());
			}
			return true;
	}
	
	public int getEmployee(String emp_name)
	{   
		List<Employee> e = le.getEmpList();
		for(Employee em:e)
		{
			if(em.getEmpName()==emp_name)
			{
				return 1;
			}
		}
		return 0;
	}
	public String updateEmployee(String name,int id)
	{
		List<Employee> employees=le.getEmpList();
		for(Employee em:employees)
		{
			if(em.getEmpId()==id)
			{
				em.setEmpName(name);
				System.out.println("Employee with id:"+id+" is updated to:"+name);
				return em.getEmpName();
			}
		}
		return "not found";
	}
	
	public int deleteEmployee(int id)
	{
		List<Employee> employees=le.getEmpList();
		if(employees==null) 
			return 0;
		else 
		{
			for(Employee em:employees)
			{
				if(em.getEmpId()==id)
				{
					employees.remove(em);
					return 1;
				}
			}
		}
		return 0;
	}
	public int getSalaryFromDept(String dept)
	{
		List<Employee> employees=le.getEmpList();
		for(Employee em:employees)
		{
			if(em.getDept().equals(dept))
			{
				return em.getSalary();
			}
		}
		return (Integer) null;
	}
}
