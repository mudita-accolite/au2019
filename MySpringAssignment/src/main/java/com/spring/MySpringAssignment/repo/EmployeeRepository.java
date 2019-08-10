package com.spring.MySpringAssignment.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spring.MySpringAssignment.model.Employee;
 
public interface EmployeeRepository extends CrudRepository<Employee, Long>
{
    List<Employee> findByLastName(String lastName);
}
 

