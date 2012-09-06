
package com.jverstry.DAO;

import com.jverstry.Item.MilliTimeItem;

public interface MyPersistenceDAO {

	long createMilliTimeItem();
	
	MilliTimeItem getMilliTimeItem(long id);
	
}
