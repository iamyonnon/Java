
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="projects")
public class Project implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4454340971876308625L;
	@Id
	private Long projectID;
	@Column(nullable = false, unique = true)
	private String projectName;
	private String type;
	
	@ElementCollection
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<String> versions;
	
	@ElementCollection
	private List<EmployeeProject> empls = new ArrayList<EmployeeProject>();
	
	public Project() {
	}

	/**
	 * @param projectID
	 * @param projectName
	 * @param type
	 * @param versions
	 */
	public Project(Long projectID, String projectName, String type, Set<String> versions) {
		this.projectID = projectID;
		this.projectName = projectName;
		this.type = type;
		this.versions = versions;
	}

	/**
	 * @return the projectID
	 */
	public Long getProjectID() {
		return projectID;
	}

	/**
	 * @param projectID the projectID to set
	 */
	public void setProjectID(Long projectID) {
		this.projectID = projectID;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the versions
	 */
	public Set<String> getVersions() {
		return versions;
	}

	/**
	 * @param versions the versions to set
	 */
	public void setVersions(Set<String> versions) {
		this.versions = versions;
	}

	/**
	 * @return the empls
	 */
	public List<EmployeeProject> getEmpls() {
		return empls;
	}

	/**
	 * @param empls the empls to set
	 */
//	public void setEmpls(List<EmployeeProject> empls) {
//		this.empls = empls;
//	}
	
	public void addDetail(Employee employee, int hours) {
		EmployeeProject detail = new EmployeeProject(employee, hours);
		empls.add(detail);
	}

	@Override
	public String toString() {
		return "Project [projectID=" + projectID + ", projectName=" + projectName + ", type=" + type + ", versions="
				+ versions + "]";
	}
}
