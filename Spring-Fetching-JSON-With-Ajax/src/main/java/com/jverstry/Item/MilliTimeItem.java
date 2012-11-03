
package com.jverstry.Item;

public class MilliTimeItem {
	
	private long ID;
	
	public MilliTimeItem() { }
	
	public MilliTimeItem(long init) {
		this.ID = init;
	}
	
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
	
}
