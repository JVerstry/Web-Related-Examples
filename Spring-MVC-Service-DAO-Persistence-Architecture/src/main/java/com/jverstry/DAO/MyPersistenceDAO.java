
package com.jverstry.DAO;

import com.jverstry.Item.MilliTimeItem;
import java.util.List;

public interface MyPersistenceDAO {

	long createMilliTimeItem();
	
	MilliTimeItem getMilliTimeItem(long id);
	
	String getEntityManagerStatus();
	
	List<Exception> getExceptions();
	
}
