package facade;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entity.Project;

public interface ProjectFacade extends Remote{
	
	public boolean addProject(Project prj) throws RemoteException;
	public Project getProject(String name) throws RemoteException;
}
