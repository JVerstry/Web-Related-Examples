
package com.jverstry.standalone.TransactionType;

import com.jverstry.standalone.CRUD.Item;
import javax.annotation.Resource;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

public class JTAExample {
	
	@PersistenceContext(unitName="MyPersistenceUnit")
	private EntityManager EM;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void myMethod() throws Exception {

		Item i = EM.find(Item.class, 997);

        // ...

    }	
	
	@Resource
	private UserTransaction UT;
	
    public void manualTransaction() throws IllegalStateException,
			SystemException {

		try { 
			UT.begin();
			// Operations...
		    UT.commit();
		} catch(Exception ex) {
			UT.setRollbackOnly();
		}
		
    }	

}
