package com.model;

import com.model.Employee;
import com.model.Response;

//Interface to declare the employee services available
public interface EmployeeService {
	public Employee getEmployee(int id);

	public Employee[] getAllEmployees();

	public Response addEmployee(Employee p);

	public Response modifyEmployeeName(Employee p);

	public Response deleteEmployee(int id);

}
