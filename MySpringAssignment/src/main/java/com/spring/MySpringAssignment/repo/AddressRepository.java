package com.spring.MySpringAssignment.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spring.MySpringAssignment.model.Address;

public interface AddressRepository extends CrudRepository<Address, Long>{
//   List<Address> findByLastName(String lastName);
}