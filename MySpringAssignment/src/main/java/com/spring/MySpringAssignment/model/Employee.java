package com.spring.MySpringAssignment.model;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
 
//table will be created in database by using these annotations
	@Entity
	@Table(name = "employee")
	public class Employee implements Serializable {
		
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name="a_id")
		private Address address ;

		private static final long serialVersionUID = -3009157732242241606L;
		@Id
		@Column(name="id")
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
	 
		@Column(name = "firstname")
		private String firstName;
	 
		@Column(name = "lastname")
		private String lastName;
		
		
		public Employee() {}
	 
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public Employee(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
		}
	 
		
	}


