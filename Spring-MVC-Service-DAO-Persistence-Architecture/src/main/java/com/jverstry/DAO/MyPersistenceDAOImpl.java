
package com.jverstry.DAO;

import com.jverstry.Item.MilliTimeItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MyPersistenceDAOImpl implements MyPersistenceDAO {

	@PersistenceContext
	private EntityManager em;	
	
	private List<Exception> le = new ArrayList<Exception>();
	
	@Override
	@Transactional
	public long createMilliTimeItem() {
		
		long result = 0;
		le.clear();
		
		StringBuilder sb = new StringBuilder();
		
		for ( Map.Entry<String, Object> ps : em.getProperties().entrySet() ) {
			sb.append('\n').append(ps.getKey()).append(" - ").append(ps.getValue());
		}

		le.add(new Exception("Properties: " + sb.toString()));
		
		try {
		
			MilliTimeItem mti = new MilliTimeItem();
			mti.setMilliTime(System.currentTimeMillis());
			
			le.add(new Exception("Milli created: " + mti));
			em.persist(mti);
		
			result = mti.getID();
			le.add(new Exception("Milli id: " + result));
			
			em.detach(mti);
			
		} catch (Exception ex) {
			le.add(ex);
		}
		
		return result;
		
	}

	@Override
	@Transactional
	public MilliTimeItem getMilliTimeItem(long id) {
		
		MilliTimeItem result = null;
		
		try {
			
			result = em.find(MilliTimeItem.class, id);
			le.add(new Exception("Retrieved milli: " + result));
			
		} catch (Exception ex) {
			le.add(ex);
		}
		
		return result;
		
	}

	@Override
	public String getEntityManagerStatus() {
		
		if ( this.em != null ) {
			return "Entity Manager is not null!";
		} else {
			return "Entity Manager is null!";
		}

	}

	@Override
	public List<Exception> getExceptions() {
		return new ArrayList<Exception>(le);
	}
	
}
