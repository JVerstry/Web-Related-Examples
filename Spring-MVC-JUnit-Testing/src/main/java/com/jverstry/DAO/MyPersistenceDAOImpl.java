
package com.jverstry.DAO;

import com.jverstry.Item.MilliTimeItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MyPersistenceDAOImpl implements MyPersistenceDAO {

	@PersistenceContext
	private EntityManager em;	
	
	@Override
	@Transactional
	public long createMilliTimeItem() {
		
		MilliTimeItem mti = new MilliTimeItem();
		mti.setMilliTime(System.currentTimeMillis());

		em.persist(mti);
		long result = mti.getID();
		em.detach(mti);
		
		return result;
		
	}

	@Override
	@Transactional
	public MilliTimeItem getMilliTimeItem(long id) {
		
		return em.find(MilliTimeItem.class, id);
		
	}
	
}
