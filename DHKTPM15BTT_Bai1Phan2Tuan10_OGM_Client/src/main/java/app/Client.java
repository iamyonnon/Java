package app;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.Set;

import entity.Project;
import facade.ProjectFacade;

public class Client {
	public static void main(String[] args) {
		
//		Arrays.asList(1).forEach(x -> System.out.println(x));
		
		SecurityManager securityManager = System.getSecurityManager();
		if(securityManager == null) {
			System.setProperty("java.security.policy", "myrmi/myrmi.policy");
			System.setSecurityManager(new SecurityManager());
		}
		
		try {
			ProjectFacade projectFacade = (ProjectFacade) Naming.lookup("rmi://192.168.1.73:1099/projectFacade");
			
			Set<String> versions = new HashSet<String>();
			versions.add("1.0.0");
			versions.add("1.0.1");
			versions.add("1.0.2");
			Project prj = new Project(5000l, "Project 5000", "Software", versions);

			System.out.println("\n=========1. Thêm một đối tượng Project và EmployeeProject vào MongoDB=========");
			try {
				boolean result1 = projectFacade.addProject(prj);
				if(result1)
					System.out.println("Inserted!");

			}catch (Exception e) {
				System.out.println("Error!");
				System.out.println(e.getMessage());
			}
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
