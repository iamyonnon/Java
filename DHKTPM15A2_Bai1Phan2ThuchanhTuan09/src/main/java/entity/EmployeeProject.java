
package entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class EmployeeProject implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7345813129174363740L;
	
	@ManyToOne
	@JoinColumn(name="employeeID")
	private  Employee employee;
	
	private int hours;
	
	public EmployeeProject() {
	}

	/**
	 * @param employee
	 * @param hours
	 */
	public EmployeeProject(Employee employee, int hours) {
		this.employee = employee;
		this.hours = hours;
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return the hours
	 */
	public int getHours() {
		return hours;
	}

	/**
	 * @param hours the hours to set
	 */
	public void setHours(int hours) {
		this.hours = hours;
	}

	@Override
	public String toString() {
		return "EmployeeProject [employee=" + employee + ", hours=" + hours + "]";
	}
}
