
package com.jverstry.Data;

public class SomeData {
	
	private String name;
	private long time;
	
	public SomeData(String name, long time) {
		
		this.name = name;
		this.time = time;
		
	}
	
	public SomeData() {
		
		name = "";
		time = System.currentTimeMillis();
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}
	
}
