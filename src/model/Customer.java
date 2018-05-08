package model;

import java.time.LocalDate;


public class Customer extends Person {
	
	private String customerId;
	private boolean active;
	
	
	public Customer(String firstname, String lastName, LocalDate dateOfBirth,
			String customerId, boolean active) throws Exception {
		super(firstname, lastName, dateOfBirth);
		this.setCustomerId(customerId);
		this.active = active;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	
	public static void checkCustomerId(String customerId) throws Exception{
		if (!customerId.matches("[A-Z]{2}[0-9]{3}")){
			throw new java.lang.IllegalArgumentException("Invalid customer ID "+customerId+", use format AB123 (2 letters and 3 numbers)");			
		}
	}
	
	public void setCustomerId(String customerId)  throws Exception{
		checkCustomerId(customerId);
		this.customerId = customerId;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	public static String getListHeader(){
		return String.format("%-8s|%-30s|%9s","Cust.ID","Name","BirthDate");
	}
	
	@Override
	public String toString() {
		String result;
		result = String.format("%-8s|%-30s|%9s", 
				this.getCustomerId(), 
				this.getFullname(), 
				this.getDateOfBirth()
		);
		return result;
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
