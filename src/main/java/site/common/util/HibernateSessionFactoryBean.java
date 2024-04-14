package site.common.util;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.hibernate.ejb.HibernateEntityManagerFactory;
import org.springframework.beans.factory.FactoryBean;

public class HibernateSessionFactoryBean implements FactoryBean {

	private EntityManagerFactory entityManagerFactory;

	private SessionFactory sessionFactory;

	public Object getObject() throws Exception {
		if (sessionFactory == null) {
			sessionFactory = ((HibernateEntityManagerFactory) entityManagerFactory)
					.getSessionFactory();
		}
		return sessionFactory;
	}

	public Class getObjectType() {
		return SessionFactory.class;
	}

	public boolean isSingleton() {
		return true;
	}

	public void setEntityManagerFactory(
			EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

}
