
package com.jverstry.Service;

import com.jverstry.Item.MilliTimeItem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface MyService {
	
	@Transactional
	long create();
			
	@Transactional
	MilliTimeItem retrieve(long id);
	
}
