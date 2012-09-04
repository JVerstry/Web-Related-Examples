
package com.jverstry.Service;

import com.jverstry.Configuration.JpaTestConfig;
import com.jverstry.Configuration.TestConfig;
import com.jverstry.Item.MilliTimeItem;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ JpaTestConfig.class, TestConfig.class })
public class MyServiceImplTest {
	
    @Autowired
    private MyService myService;

	@Test
	public void testCreateAndRetrieve() {
		
		MilliTimeItem retr = myService.createAndRetrieve();
		
		assertNotNull(retr);
		
	}
	
}
