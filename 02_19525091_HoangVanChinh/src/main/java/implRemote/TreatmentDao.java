package implRemote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Treatment;
import hibernateConfig.HibernateConfig;
import iRemote.ITreatment;

public class TreatmentDao extends UnicastRemoteObject implements ITreatment {
	public TreatmentDao() throws RemoteException {
	}

	private SessionFactory sessionFactory= HibernateConfig.getInstance().getSessionFactory();

	@Override
	public boolean addTreatment(Treatment treatment) throws RemoteException {
		Session session= sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(treatment);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		return false;
	}
}
