package com.student.modal;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int rollno;

	private String name;

	private String qualification;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Address address;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Student(int rollno, String name, String qualification, Address address) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.qualification = qualification;
		this.address = address;
	}



	public Student(int id, int rollno, String name, String qualification, Address address) {
		super();
		this.id = id;
		this.rollno = rollno;
		this.name = name;
		this.qualification = qualification;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	

}
