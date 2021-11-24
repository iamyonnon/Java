package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Patients")
public class Patient implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6753499937047185447L;
	private Date dateOfBirth;
	@Column(nullable = false)
	private String firstName;
	private String gender;
	@Id
	private String id;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false)
	private String phone;
	@OneToMany(mappedBy = "patient")
	private List<Treatment> treatments;

	public Patient() {
		super();
	}

	@Override
	public String toString() {
		return "Patient [dateOfBirth=" + dateOfBirth + ", firstName=" + firstName + ", gender=" + gender + ", id=" + id
				+ ", lastName=" + lastName + ", phone=" + phone + ", treatments=" + treatments + "]";
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) throws Exception {
		if(id.matches("(PT)[0-9]{6}"))
			this.id = id;
		throw new Exception("Ma benh nhan phai la PTXXXXXX");
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Treatment> getTreatments() {
		return treatments;
	}

	public void setTreatments(List<Treatment> treatments) {
		this.treatments = treatments;
	}

	public Patient(Date dateOfBirth, String firstName, String gender, String id, String lastName, String phone) throws Exception {
		super();
		this.dateOfBirth = dateOfBirth;
		this.firstName = firstName;
		this.gender = gender;
		setId(id);
		this.lastName = lastName;
		this.phone = phone;
	}

}
