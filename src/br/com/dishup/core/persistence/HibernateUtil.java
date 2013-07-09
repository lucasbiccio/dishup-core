package br.com.dishup.core.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * @author Lucas Biccio Ribeiro
 * @since 23/03/2013
 * @version 1.0
 * Class responsible for encapsulate the logic of create connection to database
 */
public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	/**
	 * Method responsible for construct a factory of connection.
	 * This method read the database configuration from hibernate.cfg.xml file.
	 * @return session factory
	 */
	private static SessionFactory buildSessionFactory(){
		
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}
	
	/**
	 * Method responsible to return the session factory
	 * @return session factory
	 */
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
