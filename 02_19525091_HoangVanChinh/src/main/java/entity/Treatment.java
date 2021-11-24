package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(TreatmentPK.class)
@Table(name = "Treatments")
public class Treatment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3489275683944697873L;
	@Column(columnDefinition = "text" ,nullable = false)
	private String description;
	private Date endDate;
	private Date startDate;

	@Id
	@ManyToOne
	@JoinColumn(name = "patientId")
	private Patient patient;

	@Id
	@ManyToOne
	@JoinColumn(name = "doctorId")
	private Doctor doctor;

	public Treatment() {
		super();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Treatment [description=" + description + ", endDate=" + endDate + ", startDate=" + startDate
				+ ", patient=" + patient + ", doctor=" + doctor + "]";
	}

	public Treatment(String description, Date endDate, Date startDate, Patient patient) {
		super();
		this.description = description;
		this.endDate = endDate;
		this.startDate = startDate;
		this.patient = patient;
	}
}
