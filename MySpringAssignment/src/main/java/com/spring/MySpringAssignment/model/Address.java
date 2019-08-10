package com.spring.MySpringAssignment.model;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "pincode")
    private String zip;

    public Address() {

	}

    
    public Address(String address, String pincode) {
  		this.address = address;
  		this.zip = pincode;
  	}
   
	public void setId(long id) {
		this.id = id;
	}
	public long getId() {
		return id;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getZip() {
		return zip;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", address=" + address + ", zip=" + zip + "]";
	}

}
