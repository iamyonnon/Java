package implRemote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Patient;
import hibernateConfig.HibernateConfig;
import iRemote.IPatient;

public class PatientDao extends UnicastRemoteObject implements IPatient {

	public PatientDao() throws RemoteException {

	}

	private SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

	@Override
	public boolean addPatient(Patient patient) throws RemoteException {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(patient);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		return false;
	}

	@Override
	public List<Patient> getPatients(String doctorId, int month, int year) throws RemoteException {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			List<Patient> list = session.createNativeQuery("	SELECT        p.* "
					+ "	FROM            Patients AS p INNER JOIN "
					+ "	                         Treatments AS t ON p.id = t.patientId " + "	where t.doctorId='"
					+ doctorId + "' and MONTH(startDate)=" + month + " and YEAR(startDate)=" + year, Patient.class)
					.getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			tr.rollback();
		}
		return null;
	}
}
