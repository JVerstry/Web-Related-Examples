
package com.jverstry.DAO;

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
public class MyPersistenceDAOTest {
	
	@Autowired
    private MyPersistenceDAO myDAO;
	
	@Test
	public void testCreateMilliTimeItem() {
		
		// This operation should not throw an Exception
		long id = myDAO.createMilliTimeItem();
		
	}

	@Test
	public void testGetMilliTimeItem() {
		
		long id = myDAO.createMilliTimeItem();
		MilliTimeItem retr = myDAO.getMilliTimeItem(id);
		
		assertNotNull(retr);
		assertEquals(id,retr.getID());
		
	}

}
