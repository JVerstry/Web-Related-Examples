
package com.jverstry.standalone.CRUD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StandaloneHibernateJPAExample {
	
	private static EntityManagerFactory EMF;
	private static EntityManager EM;
	
	public static void main(String[] args) {

		// Creating resources
		EMF = Persistence.createEntityManagerFactory("Standalone");
		EM = EMF.createEntityManager();

		// Create
		Item i = new Item();
		i.setName("Item A");
		System.out.println("Before saving   : " + i);
		save(i);
		System.out.println("After saving    : " + i);
		
		// Read
		Item retr = get(Item.class, i.getID());
		System.out.println("Retrieved I     : " + retr);

		// Update
		i.setName("Item B");
		System.out.println("Updated         : " + i);
		update(i);
		retr = get(Item.class, i.getID());
		System.out.println("Retrieved II    : " + retr);
		
		// Delete
		System.out.println("Deleting        : " + i);
		delete(i);
		retr = get(Item.class, i.getID());
		System.out.println("Retrieved III   : " + retr);

		// Closing resources
		EM.close();
		EMF.close();
		
	}
	
	public static void save(Object o) {
		
		EntityTransaction et = EM.getTransaction();
		et.begin();
		EM.persist(o);
		et.commit();
		
	}
	
	public static <T> T get(Class<T> entityType, Object key) {
		
		return EM.find(entityType, key);
		
	}
	
	public static void update(Object o) {
		
		EntityTransaction et = EM.getTransaction();
		et.begin();
		EM.merge(o);
		et.commit();
		
	}
	
	public static void delete(Object o) {
		
		EntityTransaction et = EM.getTransaction();
		et.begin();
		EM.remove(o);
		et.commit();
		
	}
	
}
