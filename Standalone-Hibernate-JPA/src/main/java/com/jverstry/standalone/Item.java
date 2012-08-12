
package com.jverstry.standalone;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item implements Serializable {
	
	@Id
	private long ID;
	
	private String name = "";

	public long getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
