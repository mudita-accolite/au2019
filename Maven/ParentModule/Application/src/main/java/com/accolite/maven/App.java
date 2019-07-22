package com.accolite.maven;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper; 

public class App
{
    public static void main( String[] args )
    {
    	List<Employee> l = new ArrayList<Employee>();
        System.out.println( "Creating an Employee object and convert to Json:" );
        Employee e1 = new Employee("Mudita", 2525, 78);
		Employee e2 = new Employee("Shriya", 2478, 58);
		Employee e3 = new Employee("Dolly", 7689, 68);
		Employee e4 = new Employee("Shweta", 1225, 58);
		Employee e5 = new Employee("Pragati", 2541, 38);
		l.add(e1);
		l.add(e2);
		l.add(e3);
		l.add(e4);
		l.add(e5);
//		ObjectMapper obj=new ObjectMapper();
//		try { 
//            String jsonStr = obj.writeValueAsString(l); 
//            System.out.println(jsonStr); 
//        } 
//        catch (IOException e) { 
//            e.printStackTrace(); 
//        } 
		System.out.println(Util.convertToJsonString(l));
    }
    
   
}
