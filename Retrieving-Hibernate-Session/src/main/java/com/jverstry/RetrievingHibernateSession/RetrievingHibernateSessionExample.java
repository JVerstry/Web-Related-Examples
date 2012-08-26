
package com.jverstry.RetrievingHibernateSession;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RetrievingHibernateSessionExample {

	private static EntityManagerFactory EMF;
	private static EntityManager EM;
	
	public static void main(String[] args) {

		// Creating resources
		EMF = Persistence.createEntityManagerFactory("Standalone");
		EM = EMF.createEntityManager();
		
		Object o = EM.getDelegate();
		System.out.println(o.getClass());
		
		Session s = (Session) o;
		
		SessionFactory sf = s.getSessionFactory();
		
	}
	
}
