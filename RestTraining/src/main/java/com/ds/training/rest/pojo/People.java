package com.ds.training.rest.pojo;

//POJO -- plain old JAVA Object
//state holder only with getter and setter methods, no business logic
public class People {

	private String firstName;
	private String lastName;

	public People() {
	}
	
	public People(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
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
}
