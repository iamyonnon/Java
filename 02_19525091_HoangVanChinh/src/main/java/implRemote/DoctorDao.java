package implRemote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Department;
import hibernateConfig.HibernateConfig;
import iRemote.IDoctor;

public class DoctorDao extends UnicastRemoteObject implements IDoctor {
	private SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

	public DoctorDao() throws RemoteException {
	}

	@Override
	public Map<Department, Integer> getNumOfDoctorsByDepartments() throws RemoteException {

		String query="SELECT        p.* ,so=COUNT(d.id) "
				+ "FROM            Doctors AS d INNER JOIN "
				+ "                         Departments AS p ON d.departmentId = p.id "
				+ "group by p.location,p.name,p.id";
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		Map<Department, Integer> map= new HashMap();
		try {
			tr.begin();
			List<?> list=session.createNativeQuery(query).getResultList();
			
			tr.commit();
			for (Object object : list) {
				Object[] o=(Object[]) object;
				map.put(new Department((String)o[0], (String)o[1], (String)o[2]), (Integer)o[3]);
			}
			return map;
		} catch (Exception e) {
			tr.rollback();
		}
		return null;
	}

}
