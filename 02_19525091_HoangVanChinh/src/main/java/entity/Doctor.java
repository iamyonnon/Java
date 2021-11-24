package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Doctors")
public class Doctor implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6897024446831309455L;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Id
	private String id;
	@Column(nullable = false)
	private String phone;
	@Column(nullable = false)
	private String specialty;
	
	@ManyToOne
	@JoinColumn(name = "departmentId")
	private Department department;
	
	@OneToMany(mappedBy = "doctor")
	private List<Treatment> treatments;
	

	public Doctor(String id) {
		super();
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Treatment> getTreatments() {
		return treatments;
	}

	public void setTreatments(List<Treatment> treatments) {
		this.treatments = treatments;
	}

	@Override
	public String toString() {
		return "Doctor [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", id=" + id
				+ ", phone=" + phone + ", specialty=" + specialty + ", department=" + department + ", treatments="
				+ treatments + "]";
	}

	public Doctor() {
		super();
	}

	public Doctor(String email, String firstName, String lastName, String id, String phone, String specialty) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.phone = phone;
		this.specialty = specialty;
	}
}
