package model;

import java.time.LocalDate;


public class Customer extends Person {
	
	String customerId;
	boolean active;
	
	
	public Customer(String firstname, String lastName, LocalDate dateOfBirth,
			String customerId, boolean active) {
		super(firstname, lastName, dateOfBirth);
		this.customerId = customerId;
		this.active = active;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", active=" + active
				+ ", firstname=" + firstname + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result
				+ ((customerId == null) ? 0 : customerId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Customer other = (Customer) obj;
		if (customerId == null) {
			if (other.customerId != null) {
				return false;
			}
		} else if (!customerId.equals(other.customerId)) {
			return false;
		}
		return true;
	}
	
	
	
	

}
