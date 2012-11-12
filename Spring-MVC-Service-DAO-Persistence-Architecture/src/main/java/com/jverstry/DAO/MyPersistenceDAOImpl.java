
package com.jverstry.DAO;

import com.jverstry.Item.MilliTimeItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MyPersistenceDAOImpl implements MyPersistenceDAO {

	@PersistenceContext
	private EntityManager em;	
	
	@Override
	public long createMilliTimeItem() {
		
		MilliTimeItem mti = new MilliTimeItem();
		mti.setMilliTime(System.currentTimeMillis());

		em.persist(mti);
		long result = mti.getID();
		em.detach(mti);
		
		return result;
		
	}

	@Override
	public MilliTimeItem getMilliTimeItem(long id) {
		return em.find(MilliTimeItem.class, id);
	}
	
}
