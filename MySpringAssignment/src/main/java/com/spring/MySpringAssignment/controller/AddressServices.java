package com.spring.MySpringAssignment.controller;
import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.MySpringAssignment.model.Address;
import com.spring.MySpringAssignment.repo.AddressRepository;

@RestController
@RequestMapping(value ="spring/address")
public class AddressServices {
	@Autowired
	AddressRepository addressRepository;
	
	//inserting data in address table
	@RequestMapping("/insert")
    public String process(){
        addressRepository.save(new Address("Delhi","111111"));
        addressRepository.save(new Address("noida","211111"));
        addressRepository.save(new Address("gurugram","811111"));
        return "Done";
    }
	
	//method for finding all employee by pincode 
	@RequestMapping("/findallbypincode")
    public String findAll(){
        String result = "<html>";
          
        for(Address addrs : addressRepository.findAll()){
            result += "<div>" + addrs.toString() + "</div>";
        }
          
        return result + "</html>";
    }
	
}

