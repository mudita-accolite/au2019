package com.spring.MySpringAssignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.MySpringAssignment.model.Employee;
import com.spring.MySpringAssignment.repo.EmployeeRepository;

@RestController
public class WebController {
	// this value we will be reading from the application.propeties file
	@Value("${a}")
	private int a;
	@Autowired
	EmployeeRepository repository;

	// saving values in the database
	@RequestMapping("/save")
	public String process() {
		repository.save(new Employee("Mudita", "Saxena"));
		repository.save(new Employee("Shriya", "Pandey"));
		repository.save(new Employee("Akash", "Saxena"));
		repository.save(new Employee("Uzma", "Kaleem"));
		repository.save(new Employee("Aradhya", "shrivastava"));
		return "Done";
	}

	// method to find all employees
	@RequestMapping("/findall")
	public String findAll() {
		String result = "<html>";
		result += "<div>" + "The list of employees are...," + "</div>";
		for (Employee emp : repository.findAll()) {
			result += "<div>" + emp.toString() + "</div>";
		}

		// System.out.println(a);
		return result + "</html>";
	}

	
	// method to find an employee by id
   @RequestMapping("/findbyid")
	public String findById(@RequestParam("id") long id) {
		String result = "";
		result = repository.findById(id).toString();
		return result;
	}
   
   //finding an employee by lastname

	@RequestMapping("/findbylastname")
	public String fetchDataByLastName(@RequestParam("lastname") String lastName) {
		String result = "<html>";
		result += "<div>" + "There are " + a + " employees. (this value ( "+a +") has been read from application.properties file)..The list of filtered employees are," +"</br>"+ "</div>";
		for (Employee emp : repository.findByLastName(lastName)) {
			result += "<div>" + emp.toString() + "</div>";
		}

		return result + "</html>";

	}
}