package entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5717285145652153921L;
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> phoneNumbers;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<Booking> reservedRooms;
	
	public Customer() {
	}

	public Customer(String id, String firstName, String lastName, String gender, String email,
			Set<String> phoneNumbers) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.phoneNumbers = phoneNumbers;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public List<Booking> getReservedRooms() {
		return reservedRooms;
	}

	public void setReservedRooms(List<Booking> reservedRooms) {
		this.reservedRooms = reservedRooms;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", email=" + email + ", phoneNumbers=" + phoneNumbers + ", reservedRooms=" + reservedRooms + "]";
	}
	
	
	
}
