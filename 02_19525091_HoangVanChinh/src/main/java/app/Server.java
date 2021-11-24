package app;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import iRemote.IDoctor;
import iRemote.IPatient;
import iRemote.ITreatment;
import implRemote.DoctorDao;
import implRemote.PatientDao;
import implRemote.TreatmentDao;

public class Server {
	public static void main(String[] args) throws RemoteException, NamingException {
		SecurityManager securityManager = System.getSecurityManager();

		if (securityManager == null) {
			System.setProperty("java.security.policy", "rmi/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}

		IDoctor iDoctor = new DoctorDao();
		IPatient iPatient = new PatientDao();
		ITreatment iTreatment = new TreatmentDao();

		LocateRegistry.createRegistry(5091);
		Context context = new InitialContext();
		context.bind("rmi://LAPTOP-THASP9MT:5091/iDoctor", iDoctor);
		context.bind("rmi://LAPTOP-THASP9MT:5091/iPatient", iPatient);
		context.bind("rmi://LAPTOP-THASP9MT:5091/iTreatment", iTreatment);
		System.out.println("start....");
	}
}
