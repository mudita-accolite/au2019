package com.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//imports rest service operations that have been made available by using dependency
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.model.Employee;
import com.model.Response;

//Sets the path component to Employee to access functions
@Path("/employee")

public class EmployeeServiceImpl implements EmployeeService {

	private static Map<Integer, Employee> Employees = new HashMap<Integer, Employee>();

	public EmployeeServiceImpl() {
		Employees.put(1, new Employee("Mudita", 23, 1));
		Employees.put(2, new Employee("Shriya", 22, 2));
	}

	// fetches a employee by using id
	@GET
	@Path("/{id}/get")
	@Produces(MediaType.APPLICATION_XML)
	public Employee getEmployee(@PathParam("id") int id) {
		return Employees.get(id);
	}

	// fetches all employee
	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_XML)
	public Employee[] getAllEmployees() {
		Set<Integer> ids = Employees.keySet();
		Employee[] p = new Employee[ids.size()];
		int i = 0;
		for (Integer id : ids) {
			p[i] = Employees.get(id);
			i++;
		}
		return p;
	}
	
	// adds a new employee by accepting xml from request
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response addEmployee(Employee p) {
		Response response = new Response();
		if (Employees.get(p.getId()) != null) {
			response.setStatus(false);
			response.setMessage("Employee Already Exists");
			return response;
		}
		Employees.put(p.getId(), p);
		response.setStatus(true);
		response.setMessage("Employee created successfully");
		return response;
	}

	// modifies a employee name
    @PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	@Path("/modifyName")
	public Response modifyEmployeeName(Employee p) {
		Response response = new Response();
		if (Employees.get(p.getId()) == null) {
			response.setStatus(false);
			response.setMessage("Employee Does not Exists");
			return response;
		}
		Employee e = Employees.get(p.getId());
		e.setName(p.getName());
		response.setStatus(true);
		response.setMessage("Employee modified successfully");
		return response;
	}

	// deletes a employee by using id
    @DELETE
	@Path("/{id}/delete")
	@Produces(MediaType.APPLICATION_XML)
	public Response deleteEmployee(@PathParam("id") int id) {
		Response response = new Response();
		if (Employees.get(id) == null) {
			response.setStatus(false);
			response.setMessage("Employee Doesn't Exists");
			return response;
		}
		Employees.remove(id);
		response.setStatus(true);
		response.setMessage("Employee deleted successfully");
		return response;
	}

}
