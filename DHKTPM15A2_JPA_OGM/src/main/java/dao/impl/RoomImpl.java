package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;

import dao.RoomDao;
import entity.Room;
import util.HibernateUtil;

public class RoomImpl implements RoomDao{
	
	private EntityManager em;
	
	public RoomImpl() {
		em = HibernateUtil.getInstance().getEntityManager();
	}

	@Override
	public List<Room> getRoomByType(String roomType) {
		OgmSession session = em.unwrap(OgmSession.class);
		
		Transaction tr = session.beginTransaction();
		try {
			String query = " db.rooms.find({roomType: '"+roomType+"'})";
			 List<Room> rooms = session
					 .createNativeQuery(query, Room.class)
					 .getResultList();
			 
			 tr.commit();
			 return rooms;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return null;
	}

}
