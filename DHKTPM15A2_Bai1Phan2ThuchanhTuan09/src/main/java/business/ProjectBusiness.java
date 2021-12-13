package business;

import dao.ProjectDao;
import entity.Project;

public class ProjectBusiness {
	private ProjectDao projectDao;
	
	public ProjectBusiness() {
		projectDao = new ProjectDao();
	}
	
	public boolean addProject(Project prj) {
		//Check data valid
		return projectDao.addProject(prj);
	}
	
	public Project getProject(String name) {
		if(name == null || name.trim().equals(""))
			return null;
		return projectDao.getProject(name);
	}
}
