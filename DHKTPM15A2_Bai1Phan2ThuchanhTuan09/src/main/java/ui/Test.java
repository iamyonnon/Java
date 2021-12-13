package ui;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import entity.Employee;
import util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		Employee employee = new Employee(2220l, "Trung", "Vinh", "trugvinh@gmail.com", "0913222533");
		
		OgmSessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
		OgmSession session = sessionFactory.getCurrentSession();
		
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(employee);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
