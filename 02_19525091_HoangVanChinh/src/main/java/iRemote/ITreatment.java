package iRemote;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entity.Treatment;

public interface ITreatment extends Remote{
	public boolean addTreatment(Treatment treatment) throws RemoteException;
}
