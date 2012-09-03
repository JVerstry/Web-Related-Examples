
package com.jverstry.Service;

import com.jverstry.DAO.MyPersistenceDAO;
import com.jverstry.Item.MilliTimeItem;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class MyServiceImpl implements MyService {

	@Autowired
    private MyPersistenceDAO myDAO;	

	@Override
	public String getPersistenceStatus() {
		
		return myDAO.getEntityManagerStatus();
	
	}

	@Override
	public MilliTimeItem createAndRetrieve() {
		
		long id = myDAO.createMilliTimeItem();
		System.out.println("Milli time id = " + id);
		
		return myDAO.getMilliTimeItem(id);
		
	}

	@Override
	public List<Exception> getExceptions() {
		return myDAO.getExceptions();
	}
	
}
