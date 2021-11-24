package iRemote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.Patient;

public interface IPatient extends Remote{
	public boolean addPatient(Patient patient) throws RemoteException;
	public List<Patient> getPatients(String doctorId,int month, int year) throws RemoteException;
}
