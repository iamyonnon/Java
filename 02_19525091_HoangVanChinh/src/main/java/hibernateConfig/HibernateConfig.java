package hibernateConfig;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import entity.Department;
import entity.Doctor;
import entity.Patient;
import entity.Treatment;
import entity.TreatmentPK;

public class HibernateConfig {
	private SessionFactory sessionFactory = null;
	private static HibernateConfig instance = new HibernateConfig();

	private HibernateConfig() {
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();

		Metadata metadata = new MetadataSources(serviceRegistry).addAnnotatedClass(Department.class)
				.addAnnotatedClass(Doctor.class).addAnnotatedClass(Treatment.class).addAnnotatedClass(Patient.class)
				.addAnnotatedClass(TreatmentPK.class).getMetadataBuilder().build();
		if (sessionFactory == null)
			sessionFactory = metadata.getSessionFactoryBuilder().build();
	}

	public static HibernateConfig getInstance() {
			return instance;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
