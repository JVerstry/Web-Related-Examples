
package com.jverstry.Service;

import com.jverstry.Item.MilliTimeItem;
import java.util.List;

public interface MyService {
	
	String getPersistenceStatus();
	
	MilliTimeItem createAndRetrieve();
	
	List<Exception> getExceptions();
	
}
