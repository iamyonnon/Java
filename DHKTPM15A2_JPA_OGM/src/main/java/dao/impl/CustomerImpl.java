package dao.impl;

import javax.persistence.EntityManager;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;

import dao.CustomerDao;
import util.HibernateUtil;

public class CustomerImpl implements CustomerDao{

	private EntityManager em;

	public CustomerImpl() {
		em = HibernateUtil.getInstance().getEntityManager();
	}

	@Override
	public boolean updatePhoneNumbers(String customerId, String newPhone) {
		OgmSession session = em.unwrap(OgmSession.class);

		Transaction tr = session.beginTransaction();
		try {
			String query = "db.customers.updateOne({_id: '"+customerId+"'},{$addToSet:{ phoneNumbers:'"+newPhone+"'}})";
			int rs = session
					.createNativeQuery(query)
					.executeUpdate();

			tr.commit();
			return rs > 0 ? true : false;
		} catch (Exception e) {
		}
		return false;
	}

}
