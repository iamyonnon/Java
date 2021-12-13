
package dao;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import entity.Project;
import util.HibernateUtil;

public class ProjectDao {

	private OgmSessionFactory sessionFactory;


	public ProjectDao() {
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
	
	

}
