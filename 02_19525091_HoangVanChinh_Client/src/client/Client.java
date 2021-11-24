package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

import entity.Doctor;
import entity.Patient;
import entity.Treatment;
import iRemote.IDoctor;
import iRemote.IPatient;
import iRemote.ITreatment;

public class Client {
	public static void main(String[] args) throws Exception {
		IPatient iPatient= (IPatient) Naming.lookup("rmi://LAPTOP-THASP9MT:5091/iPatient");
		IDoctor iDoctor=(IDoctor) Naming.lookup("rmi://LAPTOP-THASP9MT:5091/iDoctor");
		ITreatment iTreatment=(ITreatment) Naming.lookup("rmi://LAPTOP-THASP9MT:5091/iTreatment");
		
		Patient patient= new Patient(new Date() , "van", "nam", "PT000001", "Chinh", "0967127083");
		System.out.println(iPatient.addPatient(patient));
		
		Treatment treatment= new Treatment("chinh pro ", new Date(), new Date(), patient);
		treatment.setDoctor(new Doctor("DT110011"));
		
		System.out.println( iTreatment.addTreatment(treatment));
		
		iDoctor.getNumOfDoctorsByDepartments().entrySet().iterator().forEachRemaining(p->{
			System.out.println(p.getKey().getName()+"\t"+p.getValue()+"\n");
		});
	}
	
}
