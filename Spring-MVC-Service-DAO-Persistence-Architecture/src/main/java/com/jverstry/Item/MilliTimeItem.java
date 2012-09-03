
package com.jverstry.Item;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

@Entity
@AutoProperty
public class MilliTimeItem implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long ID;
	
	private long milliTime = 0;
	
	public long getID() {
		return ID;
	}

	public long getMilliTime() {
		return milliTime;
	}

	public void setMilliTime(long milliTime) {
		this.milliTime = milliTime;
	}
	
	@Override
	public boolean equals(Object o) {
		return Pojomatic.equals(this, o);
	}

	@Override
	public int hashCode() {
		return Pojomatic.hashCode(this);
	}

	@Override
	public String toString() {
		return Pojomatic.toString(this);
	}

}
