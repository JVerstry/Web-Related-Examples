
package com.jverstry.standalone.TransactionType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ResourceLocalExample {
	
	public void myMethod() {

		// Creating resources
		EntityManagerFactory EMF
			= Persistence.createEntityManagerFactory("Standalone");
		EntityManager EM = EMF.createEntityManager();

		// Transaction
		EntityTransaction et = EM.getTransaction();
		
		try { 
			et.begin();
			// Operations...
		    et.commit();
		} catch(Exception ex) {
			et.rollback();
		}
		
		// Closing resources
		EM.close();
		EMF.close();
		
	}
	
}
