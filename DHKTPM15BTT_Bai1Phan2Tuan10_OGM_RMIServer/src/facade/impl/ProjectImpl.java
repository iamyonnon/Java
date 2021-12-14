package facade.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import business.ProjectBusiness;
import entity.Project;
import facade.ProjectFacade;

public class ProjectImpl extends UnicastRemoteObject implements ProjectFacade {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6582346961525360482L;
	private ProjectBusiness projectBusiness;
	
	public ProjectImpl() throws RemoteException{
		projectBusiness = new ProjectBusiness();
	}

	@Override
	public boolean addProject(Project prj) throws RemoteException {
		return projectBusiness.addProject(prj);
	}

	@Override
	public Project getProject(String name) throws RemoteException {
		return projectBusiness.getProject(name);
	}

}
