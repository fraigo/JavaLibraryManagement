package model;


import java.time.LocalDate;


/**
 * Author class
 * @author Francisco Igor
 *
 */
public class Author extends Person {
	
	/**
	 * Pseudonym of author
	 */
	private String pseudonym;
	/**
	 * Speciality of author
	 */
	private Genre specialty;
	
	
	
	public Author(String firstname, String lastName, LocalDate dateOfBirth,
			String pseudonym, Genre specialty) {
		super(firstname, lastName, dateOfBirth);
		setPseudonym(pseudonym);
		setSpecialty(specialty);
	}
	
	public static String getListHeader(){
		return String.format("%-20s|%-30s|%-15s|%10s", 
				"Pseudonym",
				"Name",
				"Specialty",
				"Birth Date");
	}

	@Override
	public String toString() {
		return String.format("%-20s|%-30s|%-15s|%10s", 
					pseudonym ,
					getFullname(),
					specialty ,
					dateOfBirth );
	}

	public void setPseudonym(String pseudonym) {
		this.pseudonym = pseudonym;
	}
	
	public String getPseudonym() {
		return pseudonym;
	}
	
	public void setSpecialty(Genre specialty) {
		this.specialty = specialty;
	}
	
	public Genre getSpecialty() {
		return specialty;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((pseudonym == null) ? 0 : pseudonym.hashCode());
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
		Author other = (Author) obj;
		if (pseudonym == null) {
			if (other.pseudonym != null) {
				return false;
			}
		} else if (!pseudonym.equals(other.pseudonym)) {
			return false;
		}
		return true;
	}

	
	

}
