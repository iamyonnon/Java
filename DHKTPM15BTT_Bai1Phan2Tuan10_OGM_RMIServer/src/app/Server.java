package app;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import facade.ProjectFacade;
import facade.impl.ProjectImpl;

public class Server {
	public static void main(String[] args) {
		
		SecurityManager securityManager = System.getSecurityManager();
		if(securityManager == null) {
			System.setProperty("java.security.policy", "myrmi/myrmi.policy");
			System.setSecurityManager(new SecurityManager());
		}
		
		try {
			LocateRegistry.createRegistry(1099);
			ProjectFacade projectFacade = new ProjectImpl();
			Naming.bind("rmi://192.168.1.73:1099/projectFacade", projectFacade);
			System.out.println("Server bound in RMIRegistry");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
