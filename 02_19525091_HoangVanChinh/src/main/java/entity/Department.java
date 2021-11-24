package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "Departments")
public class Department implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String location;
	@Column(nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "department")
	private List<Doctor> doctors;

	public Department(String id, String location, String name) {
		super();
		this.id = id;
		this.location = location;
		this.name = name;
	}

	public Department() {
		super();
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", location=" + location + ", name=" + name + ", doctors=" + doctors + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

}
