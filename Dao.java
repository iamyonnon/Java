package dao;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import entity.Employee;
import entity.Project;
import util.HibernateUtil;

public class Dao {
	private OgmSessionFactory sessionFactory;


	public Dao() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}

	public boolean addProject(Project prj){
		boolean result = false;
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		try {
			session.save(prj);
			tr.commit();
			result = true;
		}catch (RuntimeException e) {
			tr.rollback();
			throw e;
		}

		return result;
	}
	
	//	db.projects.find({projectName:"Project 200"} )
	public Project getProject(String name)  {

		Project project = null;

		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		try {
			String sqlString = "db.projects.find({projectName:\""+name+"\"} )";
			List<Project> temp = session.createNativeQuery(sqlString, Project.class).getResultList();
			if(temp.size() > 0)
				project = temp.get(0);

			tr.commit();
		}catch (RuntimeException e) {
			tr.rollback();
			throw e;
		}

		return project;
	}
	
	//update một thuộc tính nhờ mã
	public boolean updatePhoneNumbers(String customerId, String newPhone) {
		OgmSession session = sessionFactory.unwrap(OgmSession.class);

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
	
	//get List by cái gì đó
	public List<Employee> getRoomByType(String roomType) {
		OgmSession session = sessionFactory.unwrap(OgmSession.class);
		
		Transaction tr = session.beginTransaction();
		try {
			String query = " db.rooms.find({roomType: '"+roomType+"'})";
			 List<Employee> rooms = session
					 .createNativeQuery(query, Employee.class)
					 .getResultList();
			 
			 tr.commit();
			 return rooms;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
	
	/*
	 * Tìm kiếm tương đối dựa vào text index
	 * Câu truy vấn tạo text index trong mongo: db.projects.ensureIndex({firstName: "text", lastName: "text"})
	 */
	
}
