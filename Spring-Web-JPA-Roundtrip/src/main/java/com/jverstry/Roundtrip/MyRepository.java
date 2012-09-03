
package com.jverstry.Roundtrip;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MyRepository {
	
	@PersistenceContext
	private EntityManager em;	
	
	@Transactional
	public List<String> performRoundtrip() {
		
		List<String> l = new ArrayList<String>();

		try {
			
			l.add("Before create");
			create(l);

			l.add("Before read I");
			read(l);
			
			l.add("Before update");
			update(l);

			l.add("Before read II");
			read(l);
			
			l.add("Before delete");
			delete(l);
			
			l.add("Before read III");
			read(l);
			
		} catch (Exception ex) {
			l.add(ex.toString());
		}
		
		return l;
		
	}
	
	private Item i = null;
	
	@Transactional
	public void create(List<String> l) {

		i = new Item();
		i.setName("Item A");
		l.add("- Before saving   : " + i);

		em.persist(i);

		l.add("- After saving    : " + i);
		
	}

	@Transactional
	public void read(List<String> l) {
		
		Item retr = em.find(Item.class, this.i.getID());
		l.add("- Retrieved       : " + retr);
		
	}

	@Transactional
	public void update(List<String> l) {
		
		i.setName("Item B");
		l.add("- Updated         : " + i);
		em.persist(i);

	}
			
	@Transactional
	public void delete(List<String> l) {
		
		l.add("- Deleting        : " + i);
		em.remove(i);

	}
	
}
