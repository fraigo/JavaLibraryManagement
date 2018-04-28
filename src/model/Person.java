package model;

import java.time.LocalDate;

public abstract class Person {
	
	String firstname;
	String lastName;
	LocalDate dateOfBirth;
	
	
	
	public Person(String firstname, String lastName, LocalDate dateOfBirth) {
		super();
		this.firstname = firstname;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getFullname(){
		return getFirstname()+" "+getLastName();
	}
	@Override
	public String toString() {
		return getFullname() + " [Born:" + dateOfBirth +"]" ;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result
				+ ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}
	
	@Override
	public abstract boolean equals(Object obj) ;
		
}
